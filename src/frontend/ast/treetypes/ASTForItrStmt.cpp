#include "ASTForItrStmt.h"
#include "ASTVisitor.h"

void ASTForItrStmt::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getVar()->accept(visitor);
    getCollection()->accept(visitor);
    getBody()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTForItrStmt::print(std::ostream &out) const {
  out << "for (" << *getVar() << " : " << *getCollection() << ") " << *getBody();
  return out;
}

std::vector<std::shared_ptr<ASTNode>> ASTForItrStmt::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(VAR);
  children.push_back(COLLECTION);
  children.push_back(BODY);
  return children;
}

llvm::Value *ASTForItrStmt::codegen() {
    return nullptr;
}
