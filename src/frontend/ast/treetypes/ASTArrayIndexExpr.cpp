#include "ASTArrayIndexExpr.h"
#include "ASTVisitor.h"

void ASTArrayIndexExpr::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getArray()->accept(visitor);
    getSubscript()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTArrayIndexExpr::print(std::ostream &out) const {
  out << "(" << *getArray() << ")[" << *getSubscript() << "]";
  return out;
} // LCOV_EXCL_LINE

std::vector<std::shared_ptr<ASTNode>> ASTArrayIndexExpr::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(ARRAY);
  children.push_back(SUBSCRIPT_EXPR);
  return children;
}

llvm::Value *ASTArrayIndexExpr::codegen() {
    return nullptr;
}
