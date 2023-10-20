#include "ASTLengthExpr.h"
#include "ASTVisitor.h"

void ASTLengthExpr::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getCollection()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTLengthExpr::print(std::ostream &out) const {
  out << "#" << *getCollection() << "";
  return out;
} // LCOV_EXCL_LINE

std::vector<std::shared_ptr<ASTNode>> ASTLengthExpr::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(COLLECTION);
  return children;
}

llvm::Value *ASTLengthExpr::codegen() {
    return nullptr;
}
