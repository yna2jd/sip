#include "ASTIncrStmt.h"
#include "ASTVisitor.h"

void ASTIncrStmt::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getExpr()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTIncrStmt::print(std::ostream &out) const {
  out << getExpr() << "++;";
  return out;
}

std::vector<std::shared_ptr<ASTNode>> ASTIncrStmt::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(EXPR);
  return children;
}

llvm::Value *ASTIncrStmt::codegen() {
    return nullptr;
}
