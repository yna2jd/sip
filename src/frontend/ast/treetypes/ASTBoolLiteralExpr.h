#pragma once

#include "ASTExpr.h"

/*! \brief Class for referencing a variable.
 */
class ASTBoolLiteralExpr : public ASTExpr {
  boolean VALUE;

public:
  ASTVariableExpr(std::string VALUE) : VALUE(VALUE) {}
  boolean getVALUE() const { return VALUE; }
  void accept(ASTVisitor *visitor) override;
  llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
