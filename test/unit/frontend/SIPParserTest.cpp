#include "ExceptionContainsWhat.h"
#include "FrontEnd.h"
#include "ParseError.h"
#include "ParserHelper.h"
#include <catch2/catch_test_macros.hpp>
#include <sstream> //basically just to get JetBrains to be quiet

TEST_CASE("SIP Parser: conditional >=", "[SIP Parser]") {
    std::stringstream stream;
    stream << R"(
      conditional(){
        var x;
        x = (3 >= 4);
        if(x>=4) x = 0;
      }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

TEST_CASE("SIP Parser: <= conditional", "[SIP Parser]") {
    std::stringstream stream;
    stream << R"(
      conditional() {
        var x;
        x = 0;
        if(x <= 4){
            x = (1 <= 2);
        }
      }
    )";

    REQUIRE(ParserHelper::is_parsable(stream));
}

TEST_CASE("SIP Parser: < conditional", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
        a(){
            var x;
            x = 8;
            if(x<10){
                x = 0 < (1 < x);
            }
        }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

