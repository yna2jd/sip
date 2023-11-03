#include "TipBool.h"
#include "TipTypeVisitor.h"

#include <string>

TipBool::TipBool() {}

bool TipBool::operator==(const TipType &other) const {
  auto otherTipBool = dynamic_cast<TipBool const *>(&other);
  if (!otherTipBool) {
    return false;
  }

  return true;
}

bool TipBool::operator!=(const TipType &other) const {
  return !(*this == other);
}

std::ostream &TipBool::print(std::ostream &out) const {
  out << std::string("bool");
  return out;
} // LCOV_EXCL_LINE

void TipBool::accept(TipTypeVisitor *visitor) {
  visitor->visit(this);
  visitor->endVisit(this);
}
