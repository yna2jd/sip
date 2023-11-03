#pragma once

#include "ASTExpr.h"
#include "ASTStmt.h"

class ASTForItrStmt : public ASTStmt {
  std::shared_ptr<ASTExpr> VAR;
  std::shared_ptr<ASTExpr> COLLECTION;
  std::shared_ptr<ASTStmt> BODY;

public:
  std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTForItrStmt(std::shared_ptr<ASTExpr> VAR, std::shared_ptr<ASTExpr> COLLECTION, std::shared_ptr<ASTStmt> BODY)
      : VAR(VAR), COLLECTION(COLLECTION), BODY(BODY) {}
  ASTExpr *getVar() const { return VAR.get(); }
  ASTExpr *getCollection() const { return COLLECTION.get(); }
  ASTStmt *getBody() const { return BODY.get(); }
  // (for right : left){ body}
  void accept(ASTVisitor *visitor) override;
  llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
