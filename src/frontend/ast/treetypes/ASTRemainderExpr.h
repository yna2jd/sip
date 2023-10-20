#pragma once

#include "ASTExpr.h"

class ASTRemainderExpr : public ASTExpr {
    std::shared_ptr<ASTExpr> NUMBEREXPR;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTRemainderExpr(std::shared_ptr<ASTExpr> NUMBEREXPR): NUMBEREXPR(NUMBEREXPR) {}
    ASTExpr *getExpr() const { return NUMBEREXPR.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
    std::ostream &print(std::ostream &out) const override;
};
