#pragma once

#include "ASTExpr.h"

class ASTTernaryExpr : public ASTExpr {
    std::shared_ptr<ASTExpr> CONDITION, TRUE, FALSE;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTTernaryExpr(std::shared_ptr<ASTExpr> CONDITION, std::shared_ptr<ASTExpr> TRUE, std::shared_ptr<ASTExpr> FALSE)
            : CONDITION(CONDITION), TRUE(TRUE), FALSE(FALSE) {}
    ASTExpr *getCondition() const { return CONDITION.get(); }
    ASTExpr *getTrue() const { return TRUE.get(); }
    ASTExpr *getFalse() const { return FALSE.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
    std::ostream &print(std::ostream &out) const override;
};
