// Generated from RCL.g4 by ANTLR 4.1

   package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RCLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		NUMBER=25, ID=26, LINE_COMMENT=27, SKIP_LINES=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'.'", "','", "'+'", "'['", "'*'", "'or'", "'('", "'not'", 
		"'<'", "'='", "'!='", "';'", "'>'", "'{'", "'and'", "'conditionals'", 
		"'signature'", "'=='", "'/'", "'}'", "'|'", "'!'", "NUMBER", "ID", "LINE_COMMENT", 
		"SKIP_LINES"
	};
	public static final String[] ruleNames = {
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NUMBER", 
		"ID", "DIGIT", "LETTER", "LOWERCASE_LETTER", "UPPERCASE_LETTER", "ESC", 
		"LINE_COMMENT", "SKIP_LINES"
	};


	public RCLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RCL.g4"; }

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
		case 31: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 32: SKIP_LINES_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\36\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\7\32\u0092\n\32\f\32\16\32\u0095\13\32\3\33\3"+
		"\33\3\33\7\33\u009a\n\33\f\33\16\33\u009d\13\33\3\34\3\34\3\35\3\35\3"+
		"\35\5\35\u00a4\n\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \5 \u00ae\n \3!\3!"+
		"\7!\u00b2\n!\f!\16!\u00b5\13!\3!\3!\3\"\3\"\3\"\3\"\2#\3\3\1\5\4\1\7\5"+
		"\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\2\19\2\1;\2\1=\2\1?\2\1A\35\2C\36\3\3\2\4\4\2"+
		"\f\f\17\17\5\2\13\f\17\17\"\"\u00bd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2"+
		"\2\13M\3\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21S\3\2\2\2\23V\3\2\2\2\25X\3\2"+
		"\2\2\27\\\3\2\2\2\31^\3\2\2\2\33`\3\2\2\2\35c\3\2\2\2\37e\3\2\2\2!g\3"+
		"\2\2\2#i\3\2\2\2%m\3\2\2\2\'z\3\2\2\2)\u0084\3\2\2\2+\u0087\3\2\2\2-\u0089"+
		"\3\2\2\2/\u008b\3\2\2\2\61\u008d\3\2\2\2\63\u008f\3\2\2\2\65\u0096\3\2"+
		"\2\2\67\u009e\3\2\2\29\u00a3\3\2\2\2;\u00a5\3\2\2\2=\u00a7\3\2\2\2?\u00ad"+
		"\3\2\2\2A\u00af\3\2\2\2C\u00b8\3\2\2\2EF\7_\2\2F\4\3\2\2\2GH\7+\2\2H\6"+
		"\3\2\2\2IJ\7\60\2\2J\b\3\2\2\2KL\7.\2\2L\n\3\2\2\2MN\7-\2\2N\f\3\2\2\2"+
		"OP\7]\2\2P\16\3\2\2\2QR\7,\2\2R\20\3\2\2\2ST\7q\2\2TU\7t\2\2U\22\3\2\2"+
		"\2VW\7*\2\2W\24\3\2\2\2XY\7p\2\2YZ\7q\2\2Z[\7v\2\2[\26\3\2\2\2\\]\7>\2"+
		"\2]\30\3\2\2\2^_\7?\2\2_\32\3\2\2\2`a\7#\2\2ab\7?\2\2b\34\3\2\2\2cd\7"+
		"=\2\2d\36\3\2\2\2ef\7@\2\2f \3\2\2\2gh\7}\2\2h\"\3\2\2\2ij\7c\2\2jk\7"+
		"p\2\2kl\7f\2\2l$\3\2\2\2mn\7e\2\2no\7q\2\2op\7p\2\2pq\7f\2\2qr\7k\2\2"+
		"rs\7v\2\2st\7k\2\2tu\7q\2\2uv\7p\2\2vw\7c\2\2wx\7n\2\2xy\7u\2\2y&\3\2"+
		"\2\2z{\7u\2\2{|\7k\2\2|}\7i\2\2}~\7p\2\2~\177\7c\2\2\177\u0080\7v\2\2"+
		"\u0080\u0081\7w\2\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083(\3\2\2"+
		"\2\u0084\u0085\7?\2\2\u0085\u0086\7?\2\2\u0086*\3\2\2\2\u0087\u0088\7"+
		"\61\2\2\u0088,\3\2\2\2\u0089\u008a\7\177\2\2\u008a.\3\2\2\2\u008b\u008c"+
		"\7~\2\2\u008c\60\3\2\2\2\u008d\u008e\7#\2\2\u008e\62\3\2\2\2\u008f\u0093"+
		"\5\67\34\2\u0090\u0092\5\67\34\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2"+
		"\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\64\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0096\u009b\59\35\2\u0097\u009a\59\35\2\u0098\u009a\5\67\34\2"+
		"\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\66\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\4\62;\2\u009f8\3\2\2\2\u00a0\u00a4\5;\36\2\u00a1\u00a4\5=\37\2"+
		"\u00a2\u00a4\7a\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2"+
		"\3\2\2\2\u00a4:\3\2\2\2\u00a5\u00a6\4c|\2\u00a6<\3\2\2\2\u00a7\u00a8\4"+
		"C\\\2\u00a8>\3\2\2\2\u00a9\u00aa\7^\2\2\u00aa\u00ae\7$\2\2\u00ab\u00ac"+
		"\7^\2\2\u00ac\u00ae\7^\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"@\3\2\2\2\u00af\u00b3\7%\2\2\u00b0\u00b2\n\2\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\b!\2\2\u00b7B\3\2\2\2\u00b8\u00b9"+
		"\t\3\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\"\3\2\u00bbD\3\2\2\2\t\2\u0093"+
		"\u0099\u009b\u00a3\u00ad\u00b3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}