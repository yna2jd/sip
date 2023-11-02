#pragma once

#include "ASTStmt.h"
#include "ASTExpr.h"
#include "ASTNumberExpr.h"

/*! \brief Class for block of statements
 */
class ASTForRngStmt : public ASTStmt {
    std::shared_ptr<ASTExpr> VAR;
    std::shared_ptr<ASTExpr> BEGIN;
    std::shared_ptr<ASTExpr> END;
    std::shared_ptr<ASTExpr> INCR;
    std::shared_ptr<ASTStmt> BODY;
public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTForRngStmt(std::shared_ptr<ASTExpr> VAR
                  , std::shared_ptr<ASTExpr> BEGIN
                  , std::shared_ptr<ASTExpr> END
                  , std::shared_ptr<ASTExpr> INCR
                  , std::shared_ptr<ASTStmt> BODY):
                    VAR(VAR)
                  , BEGIN(BEGIN)
                  , END(END)
                  , INCR(INCR)
                  , BODY(BODY) {}
    ASTForRngStmt(std::shared_ptr<ASTExpr> VAR
            , std::shared_ptr<ASTExpr> BEGIN
            , std::shared_ptr<ASTExpr> END
            , std::shared_ptr<ASTStmt> BODY):
            VAR(VAR)
            , BEGIN(BEGIN)
            , END(END)
            , INCR(std::make_shared<ASTNumberExpr>(1))
            , BODY(BODY) {}
    ASTExpr *getVar() const { return VAR.get(); }
    ASTExpr *getBegin() const { return BEGIN.get(); }
    ASTExpr *getEnd() const { return END.get(); }
    ASTExpr *getIncr() const { return (INCR.get()); }
    ASTStmt *getBody() const { return BODY.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

    std::ostream &print(std::ostream &out) const override;
};
