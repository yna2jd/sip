#include "ASTRemainderExpr.h"
#include "ASTVisitor.h"

void ASTRemainderExpr::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getExpr()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTRemainderExpr::print(std::ostream &out) const {
  out << "(%" << *getExpr() << ")";
  return out;
} 

std::vector<std::shared_ptr<ASTNode>> ASTRemainderExpr::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(NUMBEREXPR);
  return children;
}

llvm::Value *ASTRemainderExpr::codegen() {
    return nullptr;
}
