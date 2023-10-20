#pragma once

#include "ASTExpr.h"

class ASTArrayIndexExpr : public ASTExpr {
    std::shared_ptr<ASTExpr> ARRAY, SUBSCRIPT_EXPR;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTArrayIndexExpr(std::shared_ptr<ASTExpr> ARRAY,
                  std::shared_ptr<ASTExpr> SUBSCRIPT_EXPR)
            : ARRAY(ARRAY) , SUBSCRIPT_EXPR(SUBSCRIPT_EXPR) {}
    ASTExpr *getArray() const { return ARRAY.get(); }
    ASTExpr *getSubscript() const { return SUBSCRIPT_EXPR.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
    std::ostream &print(std::ostream &out) const override;
};
