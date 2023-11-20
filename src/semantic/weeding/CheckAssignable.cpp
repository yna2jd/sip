#include "CheckAssignable.h"
#include "PrettyPrinter.h"
#include "SemanticError.h"

#include <sstream>

#include "loguru.hpp"

namespace {

// Return true if expression has an l-value
bool isAssignable(ASTExpr *e) {
  if (dynamic_cast<ASTVariableExpr *>(e))
    return true;
  if (dynamic_cast<ASTAccessExpr *>(e)) {
    auto *access = dynamic_cast<ASTAccessExpr *>(e);
    if (dynamic_cast<ASTVariableExpr *>(access->getRecord())) {
      return true;
    } else if (dynamic_cast<ASTDeRefExpr *>(access->getRecord())) {
      return true;
    } else {
      return false;
    }
  }
  if (dynamic_cast<ASTFunAppExpr *>(e)) {
      // auto funApp = dynamic_cast<ASTFunAppExpr *>(e);
      return isAssignable(e);
  }
  if(dynamic_cast<ASTArrayIndexExpr *>(e)){
      auto *arrayIndex = dynamic_cast<ASTArrayIndexExpr *>(e);
      return isAssignable(arrayIndex->getArray());
//      if (dynamic_cast<ASTArrayOfExpr *>(arrayIndex->getArray())) {
//          return true;
//      } else if (dynamic_cast<ASTArrayIndexExpr *>(arrayIndex->getArray())) {
//          return true;
//      }else if(dynamic_cast<ASTFunction *>(arrayIndex->getArray())){
//          return true;
//      }else if(dynamic_cast<ASTFunction *>(arrayIndex->getArray())){
          return true;
      } else if (dynamic_cast<ASTVariableExpr *>(arrayIndex->getArray())) {
//          return true;
//      } else if (dynamic_cast<ASTDeRefExpr *>(arrayIndex->getArray())) {
//          return true;
//      } else {
//          return false;
//      }
  }
  return false;
}

} // namespace

void CheckAssignable::endVisit(ASTAssignStmt *element) {
  LOG_S(1) << "Checking assignability of " << *element;

  if (isAssignable(element->getLHS()))
    return;

  // Assigning through a pointer is also permitted
  if (dynamic_cast<ASTDeRefExpr *>(element->getLHS()))
    return;

  std::ostringstream oss;
  oss << "Assignment error on line " << element->getLine() << ": ";
  if (dynamic_cast<ASTAccessExpr *>(element->getLHS())) {
    auto *access = dynamic_cast<ASTAccessExpr *>(element->getLHS());
    oss << *access->getRecord()
        << " is an expression, and not a variable corresponding to a record\n";
  } else {
    oss << *element->getLHS() << " not an l-value\n";
  }
  throw SemanticError(oss.str());
}

void CheckAssignable::endVisit(ASTRefExpr *element) {
  LOG_S(1) << "Checking assignability of " << *element;

  if (isAssignable(element->getVar()))
    return;

  std::ostringstream oss;
  oss << "Address of error on line " << element->getLine() << ": ";
  oss << *element->getVar() << " not an l-value\n";
  throw SemanticError(oss.str());
}

void CheckAssignable::check(ASTProgram *p) {
  LOG_S(1) << "Checking assignability";
  CheckAssignable visitor;
  p->accept(&visitor);
}

void CheckAssignable::endVisit(ASTArrayIndexExpr *element) {
    LOG_S(1) << "Checking assignability of " << *element;

    if (isAssignable(element->getArray()))
        return;
    LOG_S(1) << "type: " << *element->getArray();
    std::ostringstream oss;
    oss << "Address of error on line " << element->getLine() << ": ";
    oss << *element->getArray() << " not an l-value\n";
    throw SemanticError(oss.str());
}

void CheckAssignable::endVisit(ASTForItrStmt *element) {
    LOG_S(1) << "Checking assignability of " << *element;

    if (isAssignable(element->getVar()))
        return;

    std::ostringstream oss;
    oss << "Address of error on line " << element->getLine() << ": ";
    oss << *element->getVar() << " not an l-value\n";
    throw SemanticError(oss.str());
}

void CheckAssignable::endVisit(ASTForRngStmt *element) {
    LOG_S(1) << "Checking assignability of " << *element;

    if (isAssignable(element->getVar()))
        return;

    std::ostringstream oss;
    oss << "Address of error on line " << element->getLine() << ": ";
    oss << *element->getVar() << " not an l-value\n";
    throw SemanticError(oss.str());
}

void CheckAssignable::endVisit(ASTDecrStmt *element) {
    LOG_S(1) << "Checking assignability of " << *element;

    if (isAssignable(element->getExpr()))
        return;

    std::ostringstream oss;
    oss << "Address of error on line " << element->getLine() << ": ";
    oss << *element->getExpr() << " not an l-value\n";
    throw SemanticError(oss.str());
}

void CheckAssignable::endVisit(ASTIncrStmt *element) {
    LOG_S(1) << "Checking assignability of " << *element;

    if (isAssignable(element->getExpr()))
        return;

    std::ostringstream oss;
    oss << "Address of error on line " << element->getLine() << ": ";
    oss << *element->getExpr() << " not an l-value\n";
    throw SemanticError(oss.str());
}

//void CheckAssignable::endVisit(ASTFunction *element) {
//    LOG_S(1) << "Checking assignability of " << *element;
//
//    if (isAssignable(dynamic_cast<ASTExpr *>(element->getFormals().back())))
//        return;
//
//    std::ostringstream oss;
//    oss << "Address of error on line " << element->getLine() << ": ";
//    oss << *element->dynamic_cast<ASTExpr *>(element->getFormals().back()) << " not an l-value\n";
//    throw SemanticError(oss.str());
//}