#include "ASTHelper.h"
#include "SymbolTable.h"
#include "TypeConstraintCollectVisitor.h"

#include <catch2/catch_test_macros.hpp>

#include <iostream>
#include <set>
#include <sstream>

static void runtest(std::stringstream &program,
                    std::vector<std::string> constraints) {
  auto ast = ASTHelper::build_ast(program);
  auto symbols = SymbolTable::build(ast.get());

  TypeConstraintCollectVisitor visitor(symbols.get());
  ast->accept(&visitor);

  auto collected = visitor.getCollectedConstraints();

  // Copy the vectors to sets to allow for a single equality test
  std::set<std::string> expectedSet;
  copy(constraints.begin(), constraints.end(),
       inserter(expectedSet, expectedSet.end()));

  std::set<std::string> collectedSet;
  for (int i = 0; i < collected.size(); i++) {
    std::stringstream stream;
    stream << collected.at(i);
    collectedSet.insert(stream.str());
  }

  REQUIRE(expectedSet == collectedSet);
}

TEST_CASE("TypeConstraintVisitor: const, input, alloc, assign through ptr",
          "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(short() {
 var x,y,z;
 x = input;
 y = alloc x;
 *y = x;
 z = *y;
 return z;
}
    )";

  /*
   * For all of the test cases the expected results should be written with the
   * following in mind:
   *   @l:c  lines and columns are numbered from 1 and 0, respectively
   *   ( )   non-trivial expressions are parenthesized
   *   order the order of constraints is determined by the post-order AST visit
   *   space there is no spacing between operators and their operands
   *   id    identifier expressions are mapped to their declaration
   *
   * Note that spacing is calculated immediately after the R"( in the program
   * string literals.
   */
  std::vector<std::string> expected{
      "\u27E6input@3:5\u27E7 = int",
      "\u27E6x@2:5\u27E7 = \u27E6input@3:5\u27E7",
      "\u27E6alloc x@4:5\u27E7 = \u2B61\u27E6x@2:5\u27E7",
      "\u27E6y@2:7\u27E7 = \u27E6alloc x@4:5\u27E7",
      "\u27E6y@2:7\u27E7 = \u2B61\u27E6(*y)@5:1\u27E7",
      "\u27E6y@2:7\u27E7 = \u2B61\u27E6x@2:5\u27E7",
      "\u27E6y@2:7\u27E7 = \u2B61\u27E6(*y)@6:5\u27E7",
      "\u27E6z@2:9\u27E7 = \u27E6(*y)@6:5\u27E7",
      "\u27E6short@1:0\u27E7 = () -> \u27E6z@2:9\u27E7"};

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: function reference",
          "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x, y, z;
        x = 5;
        x++;
        x--;
        y = &y;
        z = foo;
        return z;
      }
    )";

  std::vector<std::string> expected{
      "\u27E65@4:12\u27E7 = int",
      "\u27E6x@3:12\u27E7 = \u27E65@4:12\u27E7",
      "\u27E6x@3:12\u27E7 = int",
      "\u27E6&y@7:12\u27E7 = \u2B61\u27E6y@3:15\u27E7",
      "\u27E6y@3:15\u27E7 = \u27E6&y@7:12\u27E7",
      "\u27E6z@3:18\u27E7 = \u27E6foo@2:6\u27E7",
      "\u27E6foo@2:6\u27E7 = () -> \u27E6z@3:18\u27E7"};

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: if ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x;
        if (x > 0) {
          x = x + 1;
        }
        return x;
      }
    )";

  /*
   * These results do a good job of illustrating the redundancy in the
   * constraints. This arises because each expression generates its own
   * constraints in isolation.
   */
  std::vector<std::string> expected{
      "\u27E6(x>0)@4:12\u27E7 = bool",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operand is int
      "\u27E60@4:16\u27E7 = int",                    // operand is int
      "\u27E61@5:18\u27E7 = int",                    // const is int
      "\u27E6(x+1)@5:14\u27E7 = int",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operands is int
      "\u27E61@5:18\u27E7 = int",                    // operands is int
      "\u27E6x@3:12\u27E7 = \u27E6(x+1)@5:14\u27E7", // sides of assignment have
      "\u27E6(x>0)@4:12\u27E7 = bool",                // if condition is bool

      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: >= ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x;
        if (x >= 0) {
          x = x + 1;
        }
        return x;
      }
    )";

  /*
   * These results do a good job of illustrating the redundancy in the
   * constraints. This arises because each expression generates its own
   * constraints in isolation.
   */
  std::vector<std::string> expected{
      "\u27E60@4:17\u27E7 = int",                    // const is int
      "\u27E6(x>=0)@4:12\u27E7 = bool",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operand is int
      "\u27E61@5:18\u27E7 = int",                    // const is int
      "\u27E6(x+1)@5:14\u27E7 = int",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operands is int
      "\u27E61@5:18\u27E7 = int",                    // operands is int
      "\u27E6x@3:12\u27E7 = \u27E6(x+1)@5:14\u27E7", // sides of assignment have
      "\u27E6(x>=0)@4:12\u27E7 = bool",                // if condition is bool
      "\u27E6(x>=0)@4:12\u27E7 = bool",                // if condition is int
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };
  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: <= ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x;
        if (x <= 0) {
          x = x + 1;
        }
        return x;
      }
    )";

  /*
   * These results do a good job of illustrating the redundancy in the
   * constraints. This arises because each expression generates its own
   * constraints in isolation.
   */
  std::vector<std::string> expected{
      "\u27E60@4:17\u27E7 = int",                    // const is int
      "\u27E6(x<=0)@4:12\u27E7 = bool",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operand is int
      "\u27E61@5:18\u27E7 = int",                    // const is int
      "\u27E6(x+1)@5:14\u27E7 = int",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operands is int
      "\u27E61@5:18\u27E7 = int",                    // operands is int
      "\u27E6x@3:12\u27E7 = \u27E6(x+1)@5:14\u27E7", // sides of assignment have
      "\u27E6(x<=0)@4:12\u27E7 = bool",                // if condition is bool
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };
  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: Boolean Literal, == ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x, a;
        if (a==true) {
          x = x + 1;
        }
        return x;
      }
    )";

  std::vector<std::string> expected{
      "\u27E6(a==1)@4:12\u27E7 = bool",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operand is int
      "\u27E61@4:15\u27E7 = bool",                    // operand is int
      "\u27E61@5:18\u27E7 = int",                    // const is int
      "\u27E6(x+1)@5:14\u27E7 = int",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operands is int
      "\u27E61@5:18\u27E7 = int",                    // operands is int
      "\u27E6x@3:12\u27E7 = \u27E6(x+1)@5:14\u27E7", // sides of assignment have
      "\u27E6a@3:15\u27E7 = \u27E61@4:15\u27E7", 
      "\u27E6(a==1)@4:12\u27E7 = bool",                // if condition is int
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: And, Or ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x, a;
        if (a and true) {
          a = a or false;
        }
        return x;
      }
    )";

  std::vector<std::string> expected{
      "\u27E6(aand1)@4:12\u27E7 = bool",                // binexpr is int
      "\u27E6(aor0)@5:14\u27E7 = bool",                // binexpr is int
      "\u27E61@4:18\u27E7 = bool",                    // operand is int
      "\u27E60@5:19\u27E7 = bool",                    // const is int
      "\u27E6a@3:15\u27E7 = \u27E6(aor0)@5:14\u27E7", 
      "\u27E6a@3:15\u27E7 = bool", 
      "\u27E60@5:19\u27E7 = bool",
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: Not, - ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x, a;
        if (a and true) {
          a = not a;
        }
        return -x;
      }
    )";

  std::vector<std::string> expected{
      "\u27E6(aand1)@4:12\u27E7 = bool", 
      "\u27E61@4:18\u27E7 = bool", 
      "\u27E6a@3:15\u27E7 = bool",
      "\u27E6a@3:15\u27E7 = \u27E6a@5:14\u27E7", 
      "\u27E6a@5:14\u27E7 = bool",
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@7:15\u27E7",
      "\u27E6x@3:12\u27E7 = int",
      "\u27E6x@7:15\u27E7 = int"
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: while ", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
        var x;
        while (x > 0) {
          x = x - 1;
        }
        return x;
      }
    )";

  std::vector<std::string> expected{
      "\u27E60@4:19\u27E7 = int",                    // const is int
      "\u27E6(x>0)@4:15\u27E7 = bool",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operand is int
      "\u27E60@4:19\u27E7 = int",                    // operand is int
      "\u27E61@5:18\u27E7 = int",                    // const is int
      "\u27E6(x-1)@5:14\u27E7 = int",                // binexpr is int
      "\u27E6x@3:12\u27E7 = int",                    // operands is int
      "\u27E61@5:18\u27E7 = int",                    // operands is int
      "\u27E6x@3:12\u27E7 = \u27E6(x-1)@5:14\u27E7", // sides of assignment have
                                                     // same type
      "\u27E6(x>0)@4:15\u27E7 = bool",                // while condition is int
      "\u27E6foo@2:6\u27E7 = () -> \u27E6x@3:12\u27E7" // function type
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: error, output", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      bar() {
        var x;
        x = input;
        output x;
        error x;
        return 0;
      }
    )";

  std::vector<std::string> expected{
      "\u27E6input@4:12\u27E7 = int",                // input value is int
      "\u27E6x@3:12\u27E7 = \u27E6input@4:12\u27E7", // sides of assignment have
                                                     // same type
      "\u27E6x@3:12\u27E7 = int",                    // output arg is int
      "\u27E6x@3:12\u27E7 = int",                    // error arg is int
      "\u27E60@7:15\u27E7 = int",                    // int constant
      "\u27E6bar@2:6\u27E7 = () -> \u27E60@7:15\u27E7" // function type
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: funs with params",
          "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo(x) {
        return x;
      }
      bar() {
        return foo(7);
      }
    )";

  std::vector<std::string> expected{
      "\u27E6foo@2:6\u27E7 = (\u27E6x@2:10\u27E7) -> "
      "\u27E6x@2:10\u27E7",       // function with arg
      "\u27E67@6:19\u27E7 = int", // int constant
      "\u27E6foo@2:6\u27E7 = (\u27E67@6:19\u27E7) -> "
      "\u27E6foo(7)@6:15\u27E7", // function application
      "\u27E6bar@5:6\u27E7 = () -> \u27E6foo(7)@6:15\u27E7" // function
                                                            // no arg
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: main", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      main(x) {
        return 0;
      }
    )";

  std::vector<std::string> expected{
      "\u27E60@3:15\u27E7 = int", // int constant
      "\u27E6x@2:11\u27E7 = int", // main args are int
      "\u27E60@3:15\u27E7 = int", // main return is int
      "\u27E6main@2:6\u27E7 = (\u27E6x@2:11\u27E7) -> "
      "\u27E60@3:15\u27E7" // function
                           // with
                           // arg
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: polymorphic type inference",
          "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      deref(p) {
        return *p;
      }
    )";

  std::vector<std::string> expected{
      "\u27E6p@2:12\u27E7 = \u2B61\u27E6(*p)@3:15\u27E7", // deref
      "\u27E6deref@2:6\u27E7 = (\u27E6p@2:12\u27E7) -> "
      "\u27E6(*p)@3:15\u27E7", // function with param
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: record expr", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      main() {
          var r;
          r = {f: 4, g: 13};
          return 0;
      }
    )";

  std::vector<std::string> expected{
      "\u27E64@4:18\u27E7 = int",  // int constant
      "\u27E613@4:24\u27E7 = int", // int constant
      "\u27E6{f:4,g:13}@4:14\u27E7 = "
      "{f:\u27E64@4:18\u27E7,g:\u27E613@4:24\u27E7}",     // uber record
      "\u27E6r@3:14\u27E7 = \u27E6{f:4,g:13}@4:14\u27E7", // assignment
      "\u27E60@5:17\u27E7 = int",                         // int constant
      "\u27E60@5:17\u27E7 = int",                         // main return is int
      "\u27E6main@2:6\u27E7 = () -> \u27E60@5:17\u27E7"   // function decl
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: access expr", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      main() {
          var r;
          r = {f: 4, g: 13};
          return r.g;
      }

    )";

  std::vector<std::string> expected{
      "\u27E64@4:18\u27E7 = int",  // int constant
      "\u27E613@4:24\u27E7 = int", // int constant
      "\u27E6{f:4,g:13}@4:14\u27E7 = "
      "{f:\u27E64@4:18\u27E7,g:\u27E613@4:24\u27E7}",     // uber record
      "\u27E6r@3:14\u27E7 = \u27E6{f:4,g:13}@4:14\u27E7", // assignment
      "\u27E6r@3:14\u27E7 = "
      "{f:\u03B1<(r.g)@5:17[f]>,g:\u27E6(r.g)@5:17\u27E7}", // field access
    "\u27E6(r.g)@5:17\u27E7 = int",                       // main return int
      "\u27E6main@2:6\u27E7 = () -> \u27E6(r.g)@5:17\u27E7" // function decl
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: uber record", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
      foo() {
          var r;
          r = {f: 4, g: 13};
          r = {n: null, f: 13};
          return 0;
      }

    )";

  std::vector<std::string> expected{
      "\u27E64@4:18\u27E7 = int",  // int constant
      "\u27E613@4:24\u27E7 = int", // int constant
      "\u27E6{f:4,g:13}@4:14\u27E7 = "
      "{f:\u27E64@4:18\u27E7,g:\u27E613@4:24\u27E7,n:\u25C7}", // uber record
      "\u27E6r@3:14\u27E7 = \u27E6{f:4,g:13}@4:14\u27E7",      // assignment
      "\u27E6null@5:18\u27E7 = \u2B61\u03B1<null@5:18>",       // null
      "\u27E613@5:27\u27E7 = int",                             // int constant
      "\u27E6{n:null,f:13}@5:14\u27E7 = "
      "{f:\u27E613@5:27\u27E7,g:\u25C7,n:\u27E6null@5:18\u27E7}", // uber record
        "\u27E60@6:17\u27E7 = int",                      // main return int
      "\u27E6r@3:14\u27E7 = \u27E6{n:null,f:13}@5:14\u27E7",      // assignment
      "\u27E6foo@2:6\u27E7 = () -> \u27E60@6:17\u27E7" // function decl
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: record2", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
main() {
    var n, r1;
    n = alloc {p: 4, q: 2};
    *n = {p:5, q: 6};
    r1 = (*n).p;
    output r1;
    return 0;
}
    )";

  std::vector<std::string> expected{
      "\u27E64@4:18\u27E7 = int", // int constant
      "\u27E62@4:24\u27E7 = int", // int constant
      "\u27E6{p:4,q:2}@4:14\u27E7 = "
      "{p:\u27E64@4:18\u27E7,q:\u27E62@4:24\u27E7}", // record
      "\u27E6alloc {p:4,q:2}@4:8\u27E7 = "
      "\u2B61\u27E6{p:4,q:2}@4:14\u27E7",                    // alloc ptr
      "\u27E6n@3:8\u27E7 = \u27E6alloc {p:4,q:2}@4:8\u27E7", // assignment
      "\u27E6n@3:8\u27E7 = \u2B61\u27E6(*n)@5:4\u27E7",      // deref
      "\u27E65@5:12\u27E7 = int",                            // int constant
      "\u27E66@5:18\u27E7 = int",                            // int constant
      "\u27E6{p:5,q:6}@5:9\u27E7 = "
      "{p:\u27E65@5:12\u27E7,q:\u27E66@5:18\u27E7}",         // record
      "\u27E6n@3:8\u27E7 = \u2B61\u27E6{p:5,q:6}@5:9\u27E7", // assign
                                                             // through
                                                             // ptr
      "\u27E6n@3:8\u27E7 = \u2B61\u27E6(*n)@6:10\u27E7",     // deref
      "\u27E6(*n)@6:10\u27E7 = "
      "{p:\u27E6((*n).p)@6:9\u27E7,q:\u03B1<((*n).p)@6:9[q]>}", // field
                                                                // access
      "\u27E6r1@3:11\u27E7 = \u27E6((*n).p)@6:9\u27E7",         // assign
      "\u27E6r1@3:11\u27E7 = int",                              // output
      "\u27E60@8:11\u27E7 = int",                       // int constant
        "\u27E60@8:11\u27E7 = int",                       // main return int
      "\u27E6main@2:0\u27E7 = () -> \u27E60@8:11\u27E7" // fun
                                                        // declaration
  };

  runtest(program, expected);
}

TEST_CASE("TypeConstraintVisitor: record4", "[TypeConstraintVisitor]") {
  std::stringstream program;
  program << R"(
main() {
    var n, k, r1;
    k = {a: 1, b: 2};
    n = {c: &k, d: 4};
    r1 = ((*(n.c)).a); // output 1
    output r1;
    return 0;
}

    )";

  std::vector<std::string> expected{
      "\u27E61@4:12\u27E7 = int", // int constant
      "\u27E62@4:18\u27E7 = int", // int constant
      "\u27E6{a:1,b:2}@4:8\u27E7 = "
      "{a:\u27E61@4:12\u27E7,b:\u27E62@4:18\u27E7,c:\u25C7,d:\u25C7}", // record
      "\u27E6k@3:11\u27E7 = \u27E6{a:1,b:2}@4:8\u27E7",                // assign
      "\u27E6&k@5:12\u27E7 = \u2B61\u27E6k@3:11\u27E7", // address of
      "\u27E64@5:19\u27E7 = int",                       // int constant
      "\u27E6{c:&k,d:4}@5:8\u27E7 = "
      "{a:\u25C7,b:\u25C7,c:\u27E6&k@5:12\u27E7,d:\u27E64@5:19\u27E7}", // record
      "\u27E6n@3:8\u27E7 = \u27E6{c:&k,d:4}@5:8\u27E7", // assign
      "\u27E6n@3:8\u27E7 = "
      "{a:\u03B1<(n.c)@6:13[a]>,b:\u03B1<(n.c)@6:13[b]>,c:\u27E6(n.c)@6:"
      "13\u27E7,d:\u03B1<(n.c)@6:13[d]>}",                        // access
      "\u27E6(n.c)@6:13\u27E7 = \u2B61\u27E6(*(n.c))@6:11\u27E7", // assign
                                                                  // through ptr
      "\u27E6(*(n.c))@6:11\u27E7 = "
      "{a:\u27E6((*(n.c)).a)@6:10\u27E7,b:\u03B1<((*(n.c)).a)@6:10[b]>,c:"
      "\u03B1<((*(n.c)).a)@6:10[c]>,d:\u03B1<((*(n.c)).a)@6:10[d]>}", // access
      "\u27E6r1@3:14\u27E7 = \u27E6((*(n.c)).a)@6:10\u27E7",          // assign
      "\u27E6r1@3:14\u27E7 = int",                                    // output
        "\u27E60@8:11\u27E7 = int",                       // main return int
      "\u27E60@8:11\u27E7 = int",                       // int constant
      "\u27E6main@2:0\u27E7 = () -> \u27E60@8:11\u27E7" // fun declaration
  };

  runtest(program, expected);
}
