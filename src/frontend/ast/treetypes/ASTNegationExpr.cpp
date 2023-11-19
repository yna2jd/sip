#include "ASTNegationExpr.h"
#include "ASTVisitor.h"

void ASTNegationExpr::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getExpr()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTNegationExpr::print(std::ostream &out) const {
  out << *getExpr();
  return out;
} 

std::vector<std::shared_ptr<ASTNode>> ASTNegationExpr::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(EXPR);
  return children;
}
