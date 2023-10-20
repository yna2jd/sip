#pragma once

#include "ASTExpr.h"

class ASTLengthExpr : public ASTExpr {
    std::shared_ptr<ASTExpr> COLLECTION;

public:
    std::vector<std::shared_ptr<ASTNode>> getChildren() override;
    ASTLengthExpr(std::shared_ptr<ASTExpr> COLLECTION): COLLECTION(COLLECTION) {}
    ASTExpr *getCollection() const { return COLLECTION.get(); }
    void accept(ASTVisitor *visitor) override;
    llvm::Value *codegen() override;

protected:
    std::ostream &print(std::ostream &out) const override;
};
