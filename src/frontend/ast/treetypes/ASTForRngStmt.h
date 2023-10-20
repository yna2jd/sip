#pragma once

#include "ASTStmt.h"
#include "ASTExpr.h"

/*! \brief Class for block of statements
 */
class ASTForRngStmt : public ASTStmt {
    std::shared_ptr<ASTExpr> VAR;
    std::shared_ptr<ASTExpr> START;
    std::shared_ptr<ASTExpr> END;
    std::shared_ptr<ASTExpr> BY;
    std::shared_ptr<ASTStmt> BODY;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTForRngStmt(std::shared_ptr<ASTExpr> VAR
                  , std::shared_ptr<ASTExpr>
                  , std::shared_ptr<ASTExpr> END
                  , std::shared_ptr<ASTExpr> BY
                  , std::shared_ptr<ASTStmt> BODY):
                  VAR(VAR)
                  , START(START)
                  , END(END)
                  , BY(BY)
                  , BODY(BODY) {}
    ASTExpr *getVar() const { return VAR.get(); }
    ASTExpr *getStart() const { return START.get(); }
    ASTExpr *getEnd() const { return END.get(); }
    ASTExpr *getBy() const { return BY.get(); }
    ASTStmt *getBody() const { return BODY.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
  std::ostream &print(std::ostream &out) const override;
};
