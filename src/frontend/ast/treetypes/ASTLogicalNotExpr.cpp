#include "ASTLogicalNotExpr.h"
#include "ASTVisitor.h"

void ASTLogicalNotExpr::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getExpr()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTLogicalNotExpr::print(std::ostream &out) const {
  out << *getExpr();
  return out;
} 

std::vector<std::shared_ptr<ASTNode>> ASTLogicalNotExpr::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(BOOLEXPR);
  return children;
}
