#include "ASTForItrStmt.h"
#include "ASTVisitor.h"

void ASTForItrStmt::accept(ASTVisitor *visitor) {
  if (visitor->visit(this)) {
    getLeft()->accept(visitor);
    getRight()->accept(visitor);
    getBody()->accept(visitor);
  }
  visitor->endVisit(this);
}

std::ostream &ASTForItrStmt::print(std::ostream &out) const {
  out << "for (" << *getLeft() << " : " << *getRight() << ") " << *getBody();
  return out;
}

std::vector<std::shared_ptr<ASTNode>> ASTForItrStmt::getChildren() {
  std::vector<std::shared_ptr<ASTNode>> children;
  children.push_back(LEFT);
  children.push_back(RIGHT);
  children.push_back(BODY);
  return children;
}

llvm::Value *ASTForItrStmt::codegen() {
    return nullptr;
}
