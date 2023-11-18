#include "ASTBoolLiteralExpr.h"
#include "ASTVisitor.h"

void ASTBoolLiteralExpr::accept(ASTVisitor *visitor) {
  visitor->visit(this);
  visitor->endVisit(this);
}

std::ostream &ASTBoolLiteralExpr::print(std::ostream &out) const {
  out << getValue();
  return out;
}
