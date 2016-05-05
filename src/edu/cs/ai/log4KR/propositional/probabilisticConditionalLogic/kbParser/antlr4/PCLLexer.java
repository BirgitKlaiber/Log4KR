// Generated from PCL.g4 by ANTLR 4.1

	package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PCLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, FRACTIONSYMBOL=19, DECIMALMARK=20, NUMBER=21, ID=22, 
		LINE_COMMENT=23, SKIP_LINES=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "','", "'+'", "'['", "'*'", "'or'", "'not'", "'('", "'='", 
		"';'", "'{'", "'and'", "'conditionals'", "'signature'", "'}'", "'|'", 
		"'!'", "'/'", "'.'", "NUMBER", "ID", "LINE_COMMENT", "SKIP_LINES"
	};
	public static final String[] ruleNames = {
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "FRACTIONSYMBOL", "DECIMALMARK", "NUMBER", "ID", "DIGIT", "LETTER", 
		"ESC", "LINE_COMMENT", "SKIP_LINES"
	};


	public PCLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCL.g4"; }

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
		case 25: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 26: SKIP_LINES_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\32\u009d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\6\26{\n\26\r\26"+
		"\16\26|\3\27\3\27\3\27\7\27\u0082\n\27\f\27\16\27\u0085\13\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u008f\n\32\3\33\3\33\7\33\u0093\n"+
		"\33\f\33\16\33\u0096\13\33\3\33\3\33\3\34\3\34\3\34\3\34\2\35\3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1"+
		"/\2\1\61\2\1\63\2\1\65\31\2\67\32\3\3\2\5\5\2C\\aac|\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2"+
		"\2\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21H\3\2\2\2\23L\3\2\2"+
		"\2\25N\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33T\3\2\2\2\35X\3\2\2\2\37e\3\2"+
		"\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'u\3\2\2\2)w\3\2\2\2+z\3\2\2\2-~\3"+
		"\2\2\2/\u0086\3\2\2\2\61\u0088\3\2\2\2\63\u008e\3\2\2\2\65\u0090\3\2\2"+
		"\2\67\u0099\3\2\2\29:\7_\2\2:\4\3\2\2\2;<\7+\2\2<\6\3\2\2\2=>\7.\2\2>"+
		"\b\3\2\2\2?@\7-\2\2@\n\3\2\2\2AB\7]\2\2B\f\3\2\2\2CD\7,\2\2D\16\3\2\2"+
		"\2EF\7q\2\2FG\7t\2\2G\20\3\2\2\2HI\7p\2\2IJ\7q\2\2JK\7v\2\2K\22\3\2\2"+
		"\2LM\7*\2\2M\24\3\2\2\2NO\7?\2\2O\26\3\2\2\2PQ\7=\2\2Q\30\3\2\2\2RS\7"+
		"}\2\2S\32\3\2\2\2TU\7c\2\2UV\7p\2\2VW\7f\2\2W\34\3\2\2\2XY\7e\2\2YZ\7"+
		"q\2\2Z[\7p\2\2[\\\7f\2\2\\]\7k\2\2]^\7v\2\2^_\7k\2\2_`\7q\2\2`a\7p\2\2"+
		"ab\7c\2\2bc\7n\2\2cd\7u\2\2d\36\3\2\2\2ef\7u\2\2fg\7k\2\2gh\7i\2\2hi\7"+
		"p\2\2ij\7c\2\2jk\7v\2\2kl\7w\2\2lm\7t\2\2mn\7g\2\2n \3\2\2\2op\7\177\2"+
		"\2p\"\3\2\2\2qr\7~\2\2r$\3\2\2\2st\7#\2\2t&\3\2\2\2uv\7\61\2\2v(\3\2\2"+
		"\2wx\7\60\2\2x*\3\2\2\2y{\5/\30\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2},\3\2\2\2~\u0083\5\61\31\2\177\u0082\5\61\31\2\u0080\u0082\5/\30"+
		"\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084.\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\4\62;\2\u0087\60\3\2\2\2\u0088\u0089\t\2\2\2\u0089\62\3\2\2\2\u008a"+
		"\u008b\7^\2\2\u008b\u008f\7$\2\2\u008c\u008d\7^\2\2\u008d\u008f\7^\2\2"+
		"\u008e\u008a\3\2\2\2\u008e\u008c\3\2\2\2\u008f\64\3\2\2\2\u0090\u0094"+
		"\7%\2\2\u0091\u0093\n\3\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\b\33\2\2\u0098\66\3\2\2\2\u0099\u009a\t\4\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u009c\b\34\3\2\u009c8\3\2\2\2\b\2|\u0081\u0083\u008e\u0094";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}