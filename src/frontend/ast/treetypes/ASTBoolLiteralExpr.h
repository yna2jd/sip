#pragma once

#include "ASTExpr.h"

/*! \brief Class for referencing a variable.
 */
class ASTBoolLiteralExpr : public ASTExpr {
  std::string VALUE;

public:
  ASTBoolLiteralExpr(bool VALUE) : VALUE(VALUE) {}
  std::string getVALUE() const { return VALUE; }
  void accept(ASTVisitor *visitor) override;
  llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
