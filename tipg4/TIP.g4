grammar TIP;
// Grammar for Moeller and Schwartzbach's Tiny Imperative Language (TIP)

////////////////////// TIP Programs ////////////////////////// 

program : (function)+;

function : nameDeclaration 
           '(' (nameDeclaration (',' nameDeclaration)*)? ')'
           KPOLY?
           '{' (declaration*) (statement*) returnStmt '}' 
;

////////////////////// TIP Declarations ///////////////////////// 

declaration : KVAR nameDeclaration (',' nameDeclaration)* ';' ;

nameDeclaration : IDENTIFIER ;

////////////////////// TIP Expressions ////////////////////////// 

// Expressions in TIP are ordered to capture precedence.
// We adopt the C convention that orders operators as:
//   postfix, unary, multiplicative, additive, relational, and equality 
//
// NB: # creates rule label that can be accessed in visitor
//
// ANTLR4 can automatically refactor direct left-recursion so we
// place all recursive rules as options in a single rule.  This
// means that we have some complex rules here that might otherwise
// be separated out, e.g., funAppExpr, and that we can't factor out
// other useful concepts, e.g., defining a rule for the subset of
// expressions that can be used as an l-value.  We prefer a clean 
// grammar, which simplifies AST construction, and work around these
// issues elsewhere in the compiler, e.g.,  introducing an assignable expr
// weeding pass. 
//
expr : expr '(' (expr (',' expr)*)? ')' 	#funAppExpr
     | expr '.' IDENTIFIER 			#accessExpr
     | '*' expr 				#deRefExpr
     | SUB expr				#negExpr
     | '&' expr					#refExpr
     | '#' expr					#lengthExpr
     | condition = expr '?' (trueExpr = expr ':' falseExpr = expr)  #ternaryExpr
     | expr op=(MUL | DIV) expr 		#multiplicativeExpr
     | expr op=(ADD | SUB) expr 		#additiveExpr
     | expr op= MOD expr 			#remainderExpr
     | expr op=(GT | LT | GTE | LTE) expr 				#relationalExpr
     | expr op=(EQ | NE) expr 			#equalityExpr
     | expr op=(AND | OR) expr					#binaryExpr
     | op=NOT expr 			#notExpr
     | op=SUB expr 			#negationExpr
     | expr '[' expr ']'					#arrayIndexExpr
     | IDENTIFIER				#varExpr
     | NUMBER					#numExpr
     | BOOL_LITERAL			    #boolLiteralExpr
     | KINPUT					#inputExpr
     | (ARRAY | BYARRAY)					#arrayExpr
     | KALLOC expr				#allocExpr
     | KNULL					#nullExpr
     | recordExpr				#recordRule
     | '(' expr ')'				#parenExpr

;

//ternaryExpr: booltern=expr op='?' (trueExpr = expr op=':' falseExpr = expr);


recordExpr : '{' (fieldExpr (',' fieldExpr)*)? '}' ;

fieldExpr : IDENTIFIER ':' expr ;


////////////////////// TIP Statements ////////////////////////// 

statement : blockStmt
    | assignStmt
    | whileStmt
    | ifStmt
    | outputStmt
    | errorStmt
    | forItrStmt
    | forRngStmt
    | incrStmt
    | decrStmt
;

assignStmt : expr '=' expr ';' ;

blockStmt : '{' (statement*) '}' ;

whileStmt : KWHILE '(' expr ')' statement ;

ifStmt : KIF '(' expr ')' statement (KELSE statement)? ;

outputStmt : KOUTPUT expr ';'  ;

incrStmt : expr '++' ';' ;

decrStmt : expr '--' ';' ;

errorStmt : KERROR expr ';'  ;

forItrStmt : KFOR '(' expr ':' expr ')' statement ;

forRngStmtOptional : KFOR '(' expr ':' expr '..' expr ')' statement ;

forRngStmt : KFOR '(' expr ':' expr '..' expr KBY expr ')' statement ;

returnStmt : KRETURN expr ';'  ;


////////////////////// TIP Lexicon ////////////////////////// 

// By convention ANTLR4 lexical elements use all caps

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
GT  : '>' ;
GTE  : '>=' ;
LT  : '<' ;
LTE  : '<=' ;
EQ  : '==' ;
NE  : '!=' ;
NOT : 'not';
MOD : '%';
AND : 'and';
OR  : 'or';


NUMBER : [0-9]+ ;
BOOL_LITERAL: 'true'|'false';
ARRAY : '[' (expr (',' expr)*)? ']';
BYARRAY : '[' expr KBY expr ']' ;
// Placing the keyword definitions first causes ANTLR4 to prioritize
// their matching relative to IDENTIFIER (which comes later).
KALLOC  : 'alloc' ;
KINPUT  : 'input' ;
KWHILE  : 'while' ;
KIF     : 'if' ;
KELSE   : 'else' ;
KVAR    : 'var' ;
KRETURN : 'return' ;
KFOR    : 'for' ;
KBY     : 'by' ;
KNULL   : 'null' ;
KOUTPUT : 'output' ;
KERROR  : 'error' ;

// Keyword to declare functions as polymorphic
KPOLY   : 'poly' ;

IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]* ;

// ANTLR4 has a nice mechanism for specifying the characters that should
// skipped during parsing.  You write "-> skip" after the pattern and
// let ANTLR4s pattern matching do the rest.

// Ignore whitespace
WS : [ \t\n\r]+ -> skip ;

// This does not handle nested block comments.
BLOCKCOMMENT: '/*' .*? '*/' -> skip ;

COMMENT : '//' ~[\n\r]* -> skip ;
