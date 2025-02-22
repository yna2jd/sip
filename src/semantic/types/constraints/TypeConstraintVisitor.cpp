#include "TypeConstraintVisitor.h"
#include "TipAbsentField.h"
#include "TipAlpha.h"
#include "TipArray.h"
#include "TipFunction.h"
#include "TipInt.h"
#include "TipBool.h"
#include "TipRecord.h"
#include "TipRef.h"
#include "TipVar.h"

TypeConstraintVisitor::TypeConstraintVisitor(
    SymbolTable *st, std::shared_ptr<ConstraintHandler> handler)
    : symbolTable(st), constraintHandler(std::move(handler)){};

/*! \fn astToVar
 *  \brief Convert an AST node to a type variable.
 *
 * Utility function that creates type variables and uses declaration nodes
 * as a canonical representative for program variables.  There are two case
 * that need to be checked: if the variable is local to a function or if
 * it is a function value.
 */
std::shared_ptr<TipType> TypeConstraintVisitor::astToVar(ASTNode *n) {
  if (auto ve = dynamic_cast<ASTVariableExpr *>(n)) {
    ASTDeclNode *canonical;
    if ((canonical = symbolTable->getLocal(ve->getName(), scope.top()))) {
      return std::make_shared<TipVar>(canonical);
    } else if ((canonical = symbolTable->getFunction(ve->getName()))) {
      return std::make_shared<TipVar>(canonical);
    }
  } // LCOV_EXCL_LINE

  return std::make_shared<TipVar>(n);
}

bool TypeConstraintVisitor::visit(ASTFunction *element) {
  scope.push(element->getDecl());
  return true;
}

/*! \brief Type constraints for function definition.
 *
 * Type rules for "main(X1, ..., Xn) { ... return E; }":
 *   [[X1]] = [[Xn]] = [[E]] = int
 * To express this we will equate all type variables to int.
 *
 * Type rules for "X(X1, ..., Xn) { ... return E; }":
 *   [[X]] = ([[X1]], ..., [[Xn]]) -> [[E]]
 */
void TypeConstraintVisitor::endVisit(ASTFunction *element) {
  if (element->getName() == "main") {
    std::vector<std::shared_ptr<TipType>> formals;
    for (auto &f : element->getFormals()) {
      formals.push_back(astToVar(f));
      // all formals are int
      constraintHandler->handle(astToVar(f), std::make_shared<TipInt>());
    }

    // Return is the last statement and must be int
    auto ret = dynamic_cast<ASTReturnStmt *>(element->getStmts().back());
    constraintHandler->handle(astToVar(ret->getArg()), std::make_shared<TipInt>());

    constraintHandler->handle(
        astToVar(element->getDecl()),
        std::make_shared<TipFunction>(formals, astToVar(ret->getArg())));
  } else
  {
    std::vector<std::shared_ptr<TipType>> formals;
    for (auto &f : element->getFormals()) {
      formals.push_back(astToVar(f));
    }

    // Return is the last statement
    auto ret = dynamic_cast<ASTReturnStmt *>(element->getStmts().back());

    constraintHandler->handle(
        astToVar(element->getDecl()),
        std::make_shared<TipFunction>(formals, astToVar(ret->getArg())));
  }
}

/*! \brief Type constraints for numeric literal.
 *
 * Type rules for "I":
 *   [[I]] = int
 */
void TypeConstraintVisitor::endVisit(ASTNumberExpr *element) {
  constraintHandler->handle(astToVar(element), std::make_shared<TipInt>());
}
void TypeConstraintVisitor::endVisit(ASTBoolLiteralExpr *element) {
  constraintHandler->handle(astToVar(element), std::make_shared<TipBool>());
}

/*! \brief Type constraints for binary operator.
 *
 * Type rules for "E1 op E2":
 *   [[E1 op E2]] = int
 * and if "op" is not equality or disequality
 *   [[E1]] = [[E2]] = int
 * otherwise
 *   [[E1]] = [[E2]]
 */
void TypeConstraintVisitor::endVisit(ASTBinaryExpr *element) {
    auto op = element->getOp();
    if (op != "==" && op != "!=" && op != ">" && op != "<" && op != ">=" && op != "<=") {
        // operands are integer
        auto intType = std::make_shared<TipInt>();
        constraintHandler->handle(astToVar(element), intType);
        constraintHandler->handle(astToVar(element->getLeft()), intType);
        constraintHandler->handle(astToVar(element->getRight()), intType);
    } else if (op == ">" || op == "<" || op == ">=" || op == "<=") {
        constraintHandler->handle(astToVar(element), std::make_shared<TipBool>());
        constraintHandler->handle(astToVar(element->getLeft()), std::make_shared<TipInt>());
        constraintHandler->handle(astToVar(element->getRight()), std::make_shared<TipInt>());
    } else {
        auto boolType = std::make_shared<TipBool>();
        constraintHandler->handle(astToVar(element), boolType);
        constraintHandler->handle(astToVar(element->getLeft()),
                                  astToVar(element->getRight()));
    }
}

void TypeConstraintVisitor::endVisit(ASTAndExpr *element) {
  auto boolType = std::make_shared<TipBool>();
  constraintHandler->handle(astToVar(element), boolType);
  constraintHandler->handle(astToVar(element->getLeft()),
                              boolType);
  constraintHandler->handle(astToVar(element->getRight()),
                              boolType);
}

void TypeConstraintVisitor::endVisit(ASTOrExpr *element) {
  auto boolType = std::make_shared<TipBool>();
  constraintHandler->handle(astToVar(element), boolType);
  constraintHandler->handle(astToVar(element->getLeft()),
                              boolType);
  constraintHandler->handle(astToVar(element->getRight()),
                              boolType);
}

void TypeConstraintVisitor::endVisit(ASTLogicalNotExpr *element) {
  auto boolType = std::make_shared<TipBool>();
  constraintHandler->handle(astToVar(element), boolType);
  constraintHandler->handle(astToVar(element->getExpr()), boolType);
}

/*! \brief Type constraints for input statement.
 *
 * Type rules for "input":
 *  [[input]] = int
 */
void TypeConstraintVisitor::endVisit(ASTInputExpr *element) {
  constraintHandler->handle(astToVar(element), std::make_shared<TipInt>());
}

/*! \brief Type constraints for function application.
 *
 * Type Rules for "E(E1, ..., En)":
 *  [[E]] = ([[E1]], ..., [[En]]) -> [[E(E1, ..., En)]]
 */
void TypeConstraintVisitor::endVisit(ASTFunAppExpr *element) {
  std::vector<std::shared_ptr<TipType>> actuals;
  for (auto &a : element->getActuals()) {
    actuals.push_back(astToVar(a));
  }
  constraintHandler->handle(
      astToVar(element->getFunction()),
      std::make_shared<TipFunction>(actuals, astToVar(element)));
}

/*! \brief Type constraints for heap allocation.
 *
 * Type Rules for "alloc E":
 *   [[alloc E]] = &[[E]]
 */
void TypeConstraintVisitor::endVisit(ASTAllocExpr *element) {
  constraintHandler->handle(
      astToVar(element),
      std::make_shared<TipRef>(astToVar(element->getInitializer())));
}

/*! \brief Type constraints for address of.
 *
 * Type Rules for "&X":
 *   [[&X]] = &[[X]]
 */
void TypeConstraintVisitor::endVisit(ASTRefExpr *element) {
  constraintHandler->handle(
      astToVar(element), std::make_shared<TipRef>(astToVar(element->getVar())));
}

/*! \brief Type constraints for pointer dereference.
 *
 * Type Rules for "*E":
 *   [[E]] = &[[*E]]
 */
void TypeConstraintVisitor::endVisit(ASTDeRefExpr *element) {
  constraintHandler->handle(astToVar(element->getPtr()),
                            std::make_shared<TipRef>(astToVar(element)));
}

/*! \brief Type constraints for null literal.
 *
 * Type Rules for "null":
 *   [[null]] = & \alpha
 */
void TypeConstraintVisitor::endVisit(ASTNullExpr *element) {
  constraintHandler->handle(
      astToVar(element),
      std::make_shared<TipRef>(std::make_shared<TipAlpha>(element)));
}



/*! \brief Type constraints for index of array.
 *
 * Type Rules for "E1[E2]":
 *   [[E1]] = \alpha
 *   [[E2]] = int
 *
 */
void TypeConstraintVisitor::endVisit(ASTArrayIndexExpr *element) {
    constraintHandler->handle(astToVar(element->getSubscript()),
                              std::make_shared<TipInt>());
}

/*! \brief Type constraints for array of.
 *
 * Type Rules for "[E1 of E2]":
 *   [[E1]] = int
 *   [[E2]] = \alpha
 *
 */
void TypeConstraintVisitor::endVisit(ASTArrayOfExpr *element) {
    constraintHandler->handle(astToVar(element->getLeft()), std::make_shared<TipInt>());
}

/*! \brief Type constraints for array list.
 *
 * Type Rules for "[E1, E2, E3 ... En]":
 *   [[[E1, E2, E3 ... En]]] = [[E1]] = [[E2]] = [[E3]] ... = [[En]]
 *
 */
void TypeConstraintVisitor::endVisit(ASTArrayListExpr *element) {
    auto arrayElements = element->getElements();
    std::shared_ptr<TipType> arrayType;
    if(arrayElements.empty()){
        std::make_shared<TipAlpha>(element);
    }else{
        auto firstElement = arrayElements.front();
        arrayType = astToVar(firstElement);
    }
    for(auto arrayElement : arrayElements){
        constraintHandler->handle(astToVar(arrayElement), arrayType);
    }
    constraintHandler->handle(astToVar(element), std::make_shared<TipArray>(arrayType));
}

/*! \brief Type constraints for length of array.
 *
 * Type Rules for "#E1":
 *   [[E1]] = array
 *
 */
void TypeConstraintVisitor::endVisit(ASTLengthExpr *element) {
    constraintHandler->handle(astToVar(element->getCollection()), std::make_shared<TipArray>(std::make_shared<TipAlpha>(element)));
    constraintHandler->handle(astToVar(element), std::make_shared<TipInt>());
}

/*! \brief Type constraints for the iterative for loop.
 *
 * Type Rules for "for(E1 : E2)":
 *  [[E2]] = array([[E1]])
 *
 */
void TypeConstraintVisitor::endVisit(ASTForItrStmt *element) {
//    if (auto lptr = dynamic_cast<ASTDeRefExpr *>(element->getVar())) {
//        constraintHandler->handle(
//                astToVar(lptr->getPtr()),
//                std::make_shared<TipRef>(astToVar(element->getRHS())));
//    } else {
        constraintHandler->handle(astToVar(element->getCollection()), std::make_shared<TipArray>(astToVar(element->getVar())));

   // }
}

/*! \brief Type constraints for the by range for loop.
 *
 * Type Rules for "for(E1 : E2 .. E3 by E4)":
 *  [[E3]] = [[E4]] = int
 *  [[E2]] = array([[E1]])
 *
 */
void TypeConstraintVisitor::endVisit(ASTForRngStmt *element) {
    constraintHandler->handle(astToVar(element->getVar()), std::make_shared<TipInt>());
    constraintHandler->handle(astToVar(element->getIncr()), std::make_shared<TipInt>());
    constraintHandler->handle(astToVar(element->getBegin()), std::make_shared<TipInt>());
    constraintHandler->handle(astToVar(element->getEnd()), std::make_shared<TipInt>());
}

/*! \brief Type rules for assignments.
 *
 * Type rules for "E1 = E2":
 *   [[E1]] = [[E2]]
 *
 * Type rules for "*E1 = E2":
 *   [[E1]] = &[[E2]]
 *
 * Note that these are slightly more general than the rules in the SPA book.
 * The first allows for record expressions on the left hand side and the second
 * allows for more complex assignments, e.g., "**p = &x"
 */
void TypeConstraintVisitor::endVisit(ASTAssignStmt *element) {
  // If this is an assignment through a pointer, use the second rule above
  if (auto lptr = dynamic_cast<ASTDeRefExpr *>(element->getLHS())) {
    constraintHandler->handle(
        astToVar(lptr->getPtr()),
        std::make_shared<TipRef>(astToVar(element->getRHS())));
  } else {
    constraintHandler->handle(astToVar(element->getLHS()),
                              astToVar(element->getRHS()));
  }
}

/*! \brief Type constraints for while loop.
 *
 * Type rules for "while (E) S":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTWhileStmt *element) {
  if (astToVar(element->getCondition()) == std::make_shared<TipInt>()) {
    constraintHandler->handle(astToVar(element->getCondition()), std::make_shared<TipInt>());
  } else {
    constraintHandler->handle(astToVar(element->getCondition()), std::make_shared<TipBool>());
  }  
}

/*! \brief Type constraints for if statement.
 *
 * Type rules for "if (E) S1 else S2":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTIfStmt *element) {
  if (astToVar(element->getCondition()) == std::make_shared<TipInt>()) {
    constraintHandler->handle(astToVar(element->getCondition()), std::make_shared<TipInt>());
  } else {
    constraintHandler->handle(astToVar(element->getCondition()), std::make_shared<TipBool>());
  }  
}

/*! \brief Type constraints for output statement.
 *
 * Type rules for "output E":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTOutputStmt *element) {
  constraintHandler->handle(astToVar(element->getArg()),
                            std::make_shared<TipInt>());
}

/*! \brief Type constraints for record expression.
 *
 * Type rule for "{ X1:E1, ..., Xn:En }":
 *   [[{ X1:E1, ..., Xn:En }]] = { f1:v1, ..., fn:vn }
 * where fi is the ith field in the program's uber record
 * and vi = [[Ei]] if fi = Xi and \alpha otherwise
 */
void TypeConstraintVisitor::endVisit(ASTRecordExpr *element) {
  auto allFields = symbolTable->getFields();
  std::vector<std::shared_ptr<TipType>> fieldTypes;
  for (auto &f : allFields) {
    bool matched = false;
    for (auto &fe : element->getFields()) {
      if (f == fe->getField()) {
        fieldTypes.push_back(astToVar(fe->getInitializer()));
        matched = true;
        break;
      }
    }
    if (matched)
      continue;

    fieldTypes.push_back(std::make_shared<TipAbsentField>());
  }
  constraintHandler->handle(astToVar(element),
                            std::make_shared<TipRecord>(fieldTypes, allFields));
}

/*! \brief Type constraints for field access.
 *
 * Type rule for "E.X":
 *   [[E]] = { f1:v1, ..., fn:vn }
 * where fi is the ith field in the program's uber record
 * and vi = [[E.X]] if fi = X and \alpha otherwise
 */
void TypeConstraintVisitor::endVisit(ASTAccessExpr *element) {
  auto allFields = symbolTable->getFields();
  std::vector<std::shared_ptr<TipType>> fieldTypes;
  for (auto &f : allFields) {
    if (f == element->getField()) {
      fieldTypes.push_back(astToVar(element));
    } else {
      fieldTypes.push_back(std::make_shared<TipAlpha>(element, f));
    }
  }
  constraintHandler->handle(astToVar(element->getRecord()),
                            std::make_shared<TipRecord>(fieldTypes, allFields));
}

/*! \brief Type constraints for error statement.
 *
 * Type rules for "error E":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTErrorStmt *element) {
  constraintHandler->handle(astToVar(element->getArg()),
                            std::make_shared<TipInt>());
}

/*! \brief Type constraints for increment statement.
 *
 * Type rules for "error E":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTIncrStmt *element) {
    auto intType = std::make_shared<TipInt>();
    constraintHandler->handle(astToVar(element->getExpr()), intType);
}

/*! \brief Type constraints for decrement statement.
 *
 * Type rules for "error E":
 *   [[E]] = int
 */
void TypeConstraintVisitor::endVisit(ASTDecrStmt *element) {
    auto intType = std::make_shared<TipInt>();
    constraintHandler->handle(astToVar(element->getExpr()), intType);
}

void TypeConstraintVisitor::endVisit(ASTNegationExpr *element) {
    auto intType = std::make_shared<TipInt>();
    constraintHandler->handle(astToVar(element), intType);
    constraintHandler->handle(astToVar(element->getExpr()), intType);
}

/*! \brief Type constraints for ternary statement.
 *
 * Type rules for "E1 ? E2 : E3":
 *   [[E1]] = bool
 *   [[E2]] = [[E3]]
 */

void TypeConstraintVisitor::endVisit(ASTTernaryExpr *element) {
    constraintHandler->handle(astToVar(element->getCondition()), std::make_shared<TipBool>());
    constraintHandler->handle(astToVar(element->getTrue()), astToVar(element->getFalse()));
}

/* Think this is included in binary
void TypeConstraintVisitor::endVisit(ASTRemainderExpr *element) {
    auto intType = std::make_shared<TipInt>();
    constraintHandler->handle(astToVar(element), intType);
    constraintHandler->handle(astToVar(element->getLeft()), intType);
    constraintHandler->handle(astToVar(element->getRight()), intType);
} */

