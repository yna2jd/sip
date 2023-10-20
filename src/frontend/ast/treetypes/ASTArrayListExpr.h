#pragma once

#include "ASTExpr.h"
#include "ASTFieldExpr.h"

/*! \brief Class for defining an array that uses the list constructor.
 */
class ASTArrayListExpr : public ASTExpr {
  std::vector<std::shared_ptr<ASTExpr>> ELEMENTS;

public:
  std::vector<std::shared_ptr<ASTNode>> getChildren() override;
  ASTArrayListExpr(std::vector<std::shared_ptr<ASTExpr>> ELEMENTS);
  std::vector<ASTExpr *> getElements() const;
  void accept(ASTVisitor *visitor) override;
  llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
