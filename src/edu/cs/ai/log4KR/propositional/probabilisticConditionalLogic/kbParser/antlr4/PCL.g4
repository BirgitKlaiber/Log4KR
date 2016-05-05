grammar PCL;

@header {
	package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.parser.antlr4;
}

init: signature conditionals;

//Variable definitions are initiated by keyword 'variables' then one or more variables can follow
signature: 'signature' (variable (',')?)+;

//A variable can be a binary or a multivalued variable.
variable: binaryVar | multivaluedVar;

//A binary variable is initialized by writing its name.
binaryVar: varName;

//A multivalued variable is initialized by writing its name
//followed by curly brackets.
//In the brackets must be at least two comma separated values.
multivaluedVar: varName '{' varValue ',' varValue (',' varValue)* '}';

//The nameing rules of the variable and values are defined in ID.
varName: ID;
varValue: ID;

//Rule definitions start with the keyword 'rules' followed by rulesets
conditionals: 'conditionals' conditionalSet*;

//A ruleset starts with its name followed by curly brackets.
//In the brackets must be at least one rule. 
conditionalSet: conditionalSetName '{' conditional (',' conditional)* '}';

//A rule is defined by writing its formula into brackets.
//After that a probability can be assigned by appending it in square brackets, this is optional.
conditional: '(' formula ')'							#FormulaWithoutProbability
     | '(' formula ')' '[' probability ']' 				#FormulaWithProbability
     | '(' formula '|' formula ')'						#ConditionalWithoutProbability
     | '(' formula '|' formula ')' '[' probability ']'	#ConditionalWithProbability
     ;

//Nameing rules of rulesSetName are defined in ID.
conditionalSetName: ID;

formula: orexpression;
orexpression: andexpression (or andexpression)*;
andexpression: notexpression (and notexpression)*;
notexpression: not atom   #NotAtom
             | atom       #SingleAtom
             ;

atom: varName                 #AtomWithoutAlloc
      | varName '=' varValue  #AtomWithAlloc
      | '(' formula ')'       #FormulaInBrackets
      ;
 
not: '!'
   | 'not';
        
and: '*'
   | 'and'
   | ',';
   
or: '+'
  | 'or'
  | ';';
  


probability: floatingpoint
           | fraction
           ;

fraction: (NUMBER FRACTIONSYMBOL NUMBER);   

floatingpoint: (DECIMALMARK NUMBER)
             | NUMBER (DECIMALMARK NUMBER)?
             ;


FRACTIONSYMBOL: '/';
DECIMALMARK: '.';
NUMBER: DIGIT+;
ID: LETTER (LETTER | DIGIT)*;
fragment DIGIT: '0'..'9';
fragment LETTER: 'a'..'z' | 'A'..'Z' | '_';
fragment ESC: '\\"' | '\\\\';

LINE_COMMENT: '#' ~[\r\n]* -> skip;
SKIP_LINES: [ \t\r\n] -> skip;