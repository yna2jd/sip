#include "ASTDecrStmt.h"
#include "ASTVisitor.h"

void ASTDecrStmt::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getExpr()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTDecrStmt::print(std::ostream &out) const {
  out << getExpr() << "--;";
  return out;
}

std::vector<std::shared_ptr<ASTNode>> ASTDecrStmt::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(EXPR);
  return children;
}

llvm::Value *ASTDecrStmt::codegen() {
    return nullptr;
}
