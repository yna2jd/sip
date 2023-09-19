#include "ExceptionContainsWhat.h"
#include "FrontEnd.h"
#include "ParseError.h"
#include "ParserHelper.h"
#include <catch2/catch_test_macros.hpp>
#include <sstream> //basically just to get JetBrains to be quiet

//Conditionals

TEST_CASE("SIP Parser: conditional >=", "[SIP Parser]") {
    std::stringstream stream;
    stream << R"(
      conditional(in){
        var x;
        x = (3 >= 4);
        if(x>=4) x = 0;
        return in;
      }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: <= conditional", "[SIP Parser]") {
    std::stringstream stream;
    stream << R"(
      conditional(in) {
        var x;
        x = 0;
        if(x <= 4){
            x = (1 <= 2);
        }
        return in;
      }
    )";

    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: < conditional", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            var x;
            x = 8;
            if(x<10){
                x = 0 < (1 < x);
            }
            return in;
        }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: insertion stream modifiers are not supported", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
        var x;
        x << in;
        return in;
        }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: Space separated conditional", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            var x;
            x = 8;
            if(x < = 10){
                x = 0;
            }
            return in;
        }
    )";
    REQUIRE_THROWS_MATCHES(FrontEnd::parse(stream), ParseError,
                           ContainsWhat("extraneous input '='"));
}
TEST_CASE("SIP Parser: extraction stream modifiers are not supported", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
        var x;
        x >> in;
        return in;
        }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

//Increment/Decrement

TEST_CASE("SIP Parser: increment", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            var x;
            x = 8;
            x++;
            return in;
        }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: Incorrectly written increment", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            in+ +;
            return in;
        }
    )";
    REQUIRE_THROWS_MATCHES(FrontEnd::parse(stream), ParseError,
                           ContainsWhat("no viable alternative at input"));
}
TEST_CASE("SIP Parser: decrement", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            var x;
            x = 8;
            x--;
            return in;
        }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: Incorrectly written decrement", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        conditional(in){
            in- -;
            return in;
        }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

//Boolean type
TEST_CASE("SIP Parser: Boolean case", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var out;
        if(true){
            while(in == false){
                if(in > 0){
                    in = true;
                }else{
                    in = in + 1;
                }
            }
        }else{
            out = false;
        }
        out = true;
        return out;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}



//Ternary type
TEST_CASE("SIP Parser: Single ternary operator", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var x;
        x = in > 4 ? 5 : 7;
        return x;
    }
        )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

TEST_CASE("SIP Parser: Nested Ternary", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var w, x, y, z;
        x = 123;
        y = 3;
        z = 2123;
        w = in > 4 ? x <= 5 ? y < 1203 ? z == -1 : 5 : 6: 7;
        return x;
    }
        )";
    REQUIRE(ParserHelper::is_parsable(stream));
}