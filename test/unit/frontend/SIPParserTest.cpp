#include "ExceptionContainsWhat.h"
#include "FrontEnd.h"
#include "ParseError.h"
#include "ParserHelper.h"
#include <catch2/catch_test_macros.hpp>
#include <sstream> //basically just to get JetBrains to be quiet

/* Template:
 TEST_CASE("SIP Parser: test name", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){

        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
*/

//Boolean literal type
TEST_CASE("SIP Parser: Boolean literals", "[SIP Parser]") {
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

//Unary
TEST_CASE("SIP Parser: Unary negation", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = not in;
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: ! Binary Operator", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = !true;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

//Binary operator
TEST_CASE("SIP Parser: and/or Binary Operator", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = 1 and 1;
        in = 0 or 1;
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

//Array

//Array Length

//Arithmetic
TEST_CASE("SIP Parser: Arithmetic modulo", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var x;
        x = 3 % in;
    return x;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: Arithmetic modulo equals not supported", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in %= 10;
        return in;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: Arithmetic negation ", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){

        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

//Relational Operators
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


//Ternary operator
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
        var v, w, x, y, z;
        w = 1009;
        x = 123;
        y = 3;
        z = 2123;
        v = x >
            in < 4
                ? 10
                : 11
            ? x <= 5
                ? 6
                : 7
            : y < 1203
                ? 8
                :  w >= 10
                    ? 21
                    : 18
        ;
        return x;
    }
        )";
    REQUIRE(ParserHelper::is_parsable(stream));
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

//For loop iterator
TEST_CASE("SIP Parser: For Loop Iterator", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        for(i : in){
            output i;
        }
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: For Loop traditional iterator", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        for(i = 0; i > 5; i++){
            output i;
        }
        return in;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

//For loop range
TEST_CASE("SIP Parser: For Loop Range - all", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var x;
        for(x : 10 .. 1 by -1){
            output in + x;
        }
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: For Loop Range - optional", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var x;
        for(x : 2 .. 5){
            output in + x;
        }
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}
TEST_CASE("SIP Parser: For Loop traditional range", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        for i in range(10){
            output i;
        }
        return in;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}
//Array tests
TEST_CASE("SIP Parser: Empty array", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = [];
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Array initializer", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = [6, 3, 5];
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Bad array initializer", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = [6, 3,];
        return in;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: By array initializer", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = [6 by 3];
        return in;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Bad by array initializer", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        in = [6 by];
        return in;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Index of array", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var b;
	b = in[0];
        return b;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Index of array", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
        var b;
	b = [0]in;
        return b;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Length of array", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
	b = #in;
        return b;
    }
    )";
    REQUIRE(ParserHelper::is_parsable(stream));
}

 TEST_CASE("SIP Parser: Bad length of array", "[SIP Parser]"){
    std::stringstream stream;
    stream << R"(
    test(in){
	b = in#;
        return b;
    }
    )";
    REQUIRE_FALSE(ParserHelper::is_parsable(stream));
}
