grammar Log4KRCommands;

@header {
	package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.cmdParser.antlr4;
}


init: (command ';')*;

command: objectInitalization
       | objectFunctionCall
       | globalFunctionCall
       ;

objectInitalization: object '=' 'new' type '(' parameters? ')';
type: ID;

objectFunctionCall: object '.' function;

globalFunctionCall: function;

function: functionName '(' parameters? ')';
functionName: ID;
parameters: (parameter (',' parameter)*);
parameter: ID
         | STRING;

object: ID;

ID: LETTER (LETTER | DIGIT)*;
STRING: '"' (~'"')* '"'
      | '\'' (~'\'')* '\'';
fragment DIGIT: '0'..'9';
fragment LETTER: LOWERCASE_LETTER | UPPERCASE_LETTER | '_';
fragment LOWERCASE_LETTER: 'a'..'z';
fragment UPPERCASE_LETTER: 'A'..'Z';
fragment ESC: '\\"' | '\\\\';

LINE_COMMENT: '#' ~[\r\n]* -> skip;
SKIP_LINES: [ \t\r\n] -> skip;