grammar RCL;

@header {
   package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.parser.antlr4;
}

init: signature conditionals;

signature: 'signature' (sort ','?)* (predicate ','?)*;

sort: sort_name '=' '{' constant (',' constant)* '}';

predicate: predicate_name '('  ')'                            #PredicateWithoutSorts
         | predicate_name '(' sort_name (',' sort_name)* ')'  #PredicateWithSorts
         ;

conditionals: 'conditionals' conditionals_body;

conditionals_body: knowledge_bases
                 | knowledge_base_body
                 ;
                 
knowledge_bases: (knowledge_base ','?)*;

knowledge_base: knowledge_base_name '{' knowledge_base_body '}';
                 
knowledge_base_body: (conditional ','?)*;

conditional: '(' formula ')' ('[' probability ']')? ('<' constraint '>')?            #Fact
     | '(' formula '|' formula ')' ('[' probability ']')? ('<' constraint '>')?      #Cond
     ;

formula         : orexpression;
orexpression    : andexpression (or andexpression)*;
andexpression   : notexpression (and notexpression)*;
notexpression   : not atom   #NotAtom
                | atom       #SingleAtom
                ;
             
atom            : predicate_name                             #PredicateWithoutTerms
                | predicate_name '(' term (',' term)* ')'    #PredicateWithTerms
                | '(' formula ')'                            #FormulaInBrackets
                ;
 

constraint                  : constraint_orexpression;
constraint_orexpression     : constraint_andexpression (or constraint_andexpression)*;
constraint_andexpression    : constraint_notexpression (and constraint_notexpression)*;
constraint_notexpression    : not constraint_atom   #NotConstraintAtom
                            | constraint_atom       #SingleConstraintAtom
                            ;
          
constraint_atom             : variable_name '==' term            #EqualityConstraint
                            | variable_name '!=' term            #InequalityConstraint
                            | '(' constraint ')'                     #ConstraintInBrackets
                            ;

knowledge_base_name:ID;
sort_name: ID;
constant: ID;
predicate_name: ID;
variable_name: ID;
term: ID;
      
and: '*'
   | 'and'
   | ',';
   
or: '+'
  | 'or'
  | ';';
  
not: '!'
   | 'not';


probability: floatingpoint
           | fraction
           ;

fraction: (NUMBER '/' NUMBER);   

floatingpoint: ('.' NUMBER)
             | NUMBER ('.' NUMBER)?
             ;


NUMBER: DIGIT DIGIT*;
ID: LETTER (LETTER | DIGIT)*;
fragment DIGIT: '0'..'9';
fragment LETTER: LOWERCASE_LETTER | UPPERCASE_LETTER | '_';
fragment LOWERCASE_LETTER: 'a'..'z';
fragment UPPERCASE_LETTER: 'A'..'Z';
fragment ESC: '\\"' | '\\\\';

LINE_COMMENT: '#' ~[\r\n]* -> skip;
SKIP_LINES: [ \t\r\n] -> skip;