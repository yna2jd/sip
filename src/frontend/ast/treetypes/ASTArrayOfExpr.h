#pragma once

#include "ASTExpr.h"

class ASTArrayOfExpr : public ASTExpr {
    std::shared_ptr<ASTExpr> LEFT, RIGHT;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTArrayOfExpr(std::shared_ptr<ASTExpr> LEFT,
                  std::shared_ptr<ASTExpr> RIGHT)
            : LEFT(LEFT), RIGHT(RIGHT) {}
    [[nodiscard]] ASTExpr *getLeft() const { return LEFT.get(); }
    [[nodiscard]] ASTExpr *getRight() const { return RIGHT.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
    std::ostream &print(std::ostream &out) const override;
};
