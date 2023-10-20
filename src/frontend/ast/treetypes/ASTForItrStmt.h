#pragma once

#include "ASTExpr.h"
#include "ASTStmt.h"

class ASTWhileStmt : public ASTStmt {
  std::shared_ptr<ASTExpr> LEFT;
  std::shared_ptr<ASTExpr> RIGHT;
  std::shared_ptr<ASTStmt> BODY;

public:
  std::vector<std::shared_ptr<ASTNode>> getChildren() override;
  ASTWhileStmt(std::shared_ptr<ASTExpr> LEFT,std::shared_ptr<ASTExpr> RIGHT, std::shared_ptr<ASTStmt> BODY)
      : LEFT(LEFT), RIGHT(RIGHT), BODY(BODY) {}
  ASTExpr *getLeftExpr() const { return LEFT.get(); }
  ASTExpr *getRightExpr() const { return RIGHT.get(); }
  ASTStmt *getBody() const { return BODY.get(); }
  void accept(ASTVisitor *visitor) override;
  llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
