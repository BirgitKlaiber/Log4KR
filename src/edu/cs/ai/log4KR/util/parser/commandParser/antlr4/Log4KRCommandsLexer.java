// Generated from Log4KRCommands.g4 by ANTLR 4.1

	package edu.cs.ai.log4KR.util.parser.commandParser.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Log4KRCommandsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, ID=8, STRING=9, 
		LINE_COMMENT=10, SKIP_LINES=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'.'", "','", "'('", "'new'", "'='", "';'", "ID", "STRING", "LINE_COMMENT", 
		"SKIP_LINES"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", "STRING", 
		"DIGIT", "LETTER", "LOWERCASE_LETTER", "UPPERCASE_LETTER", "ESC", "LINE_COMMENT", 
		"SKIP_LINES"
	};


	public Log4KRCommandsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Log4KRCommands.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 14: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 15: SKIP_LINES_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void SKIP_LINES_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\rk\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\7\t"+
		"\67\n\t\f\t\16\t:\13\t\3\n\3\n\7\n>\n\n\f\n\16\nA\13\n\3\n\3\n\3\n\7\n"+
		"F\n\n\f\n\16\nI\13\n\3\n\5\nL\n\n\3\13\3\13\3\f\3\f\3\f\5\fS\n\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17]\n\17\3\20\3\20\7\20a\n\20\f\20"+
		"\16\20d\13\20\3\20\3\20\3\21\3\21\3\21\3\21\2\22\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\2\1\27\2\1\31\2\1\33\2\1\35\2"+
		"\1\37\f\2!\r\3\3\2\6\3\2$$\3\2))\4\2\f\f\17\17\5\2\13\f\17\17\"\"n\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2"+
		"\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r/\3\2\2\2\17\61\3"+
		"\2\2\2\21\63\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33"+
		"V\3\2\2\2\35\\\3\2\2\2\37^\3\2\2\2!g\3\2\2\2#$\7+\2\2$\4\3\2\2\2%&\7\60"+
		"\2\2&\6\3\2\2\2\'(\7.\2\2(\b\3\2\2\2)*\7*\2\2*\n\3\2\2\2+,\7p\2\2,-\7"+
		"g\2\2-.\7y\2\2.\f\3\2\2\2/\60\7?\2\2\60\16\3\2\2\2\61\62\7=\2\2\62\20"+
		"\3\2\2\2\638\5\27\f\2\64\67\5\27\f\2\65\67\5\25\13\2\66\64\3\2\2\2\66"+
		"\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\22\3\2\2\2:8\3\2\2\2;?"+
		"\7$\2\2<>\n\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?"+
		"\3\2\2\2BL\7$\2\2CG\7)\2\2DF\n\3\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3"+
		"\2\2\2HJ\3\2\2\2IG\3\2\2\2JL\7)\2\2K;\3\2\2\2KC\3\2\2\2L\24\3\2\2\2MN"+
		"\4\62;\2N\26\3\2\2\2OS\5\31\r\2PS\5\33\16\2QS\7a\2\2RO\3\2\2\2RP\3\2\2"+
		"\2RQ\3\2\2\2S\30\3\2\2\2TU\4c|\2U\32\3\2\2\2VW\4C\\\2W\34\3\2\2\2XY\7"+
		"^\2\2Y]\7$\2\2Z[\7^\2\2[]\7^\2\2\\X\3\2\2\2\\Z\3\2\2\2]\36\3\2\2\2^b\7"+
		"%\2\2_a\n\4\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3"+
		"\2\2\2ef\b\20\2\2f \3\2\2\2gh\t\5\2\2hi\3\2\2\2ij\b\21\3\2j\"\3\2\2\2"+
		"\13\2\668?GKR\\b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}