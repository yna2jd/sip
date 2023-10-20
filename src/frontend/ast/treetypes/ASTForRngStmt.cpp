#include "ASTForRngStmt.h"
#include "ASTVisitor.h"
#include "ASTinternal.h"

void ASTForRngStmt::accept(ASTVisitor *visitor) {
    if (visitor->visit(this)) {
        getVar()->accept(visitor);
        getStart()->accept(visitor);
        getEnd()->accept(visitor);
        getBy()->accept(visitor);
        getBody()->accept(visitor);
    }
    visitor->endVisit(this);
}

std::ostream &ASTForRngStmt::print(std::ostream &out) const {
    std::string by = "";
    out << "for (" << *getVar() << ":" << *getStart() << ".." << *getEnd() <<  *getBy() << ") " << *getBody();
    return out;
}

std::vector<std::shared_ptr<ASTNode>> ASTForRngStmt::getChildren() {
    std::vector<std::shared_ptr<ASTNode>> children;
    children.push_back(VAR);
    children.push_back(START);
    children.push_back(END);
    children.push_back(BY);
    children.push_back(BODY);
    return children;
}

llvm::Value *ASTForRngStmt::codegen() {
    return nullptr;
}
