// Generated from PCL.g4 by ANTLR 4.1

	package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PCLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, FRACTIONSYMBOL=19, DECIMALMARK=20, NUMBER=21, ID=22, 
		LINE_COMMENT=23, SKIP_LINES=24;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "','", "'+'", "'['", "'*'", "'or'", "'not'", 
		"'('", "'='", "';'", "'{'", "'and'", "'conditionals'", "'signature'", 
		"'}'", "'|'", "'!'", "'/'", "'.'", "NUMBER", "ID", "LINE_COMMENT", "SKIP_LINES"
	};
	public static final int
		RULE_init = 0, RULE_signature = 1, RULE_variable = 2, RULE_binaryVar = 3, 
		RULE_multivaluedVar = 4, RULE_varName = 5, RULE_varValue = 6, RULE_conditionals = 7, 
		RULE_conditionalSet = 8, RULE_conditional = 9, RULE_conditionalSetName = 10, 
		RULE_formula = 11, RULE_orexpression = 12, RULE_andexpression = 13, RULE_notexpression = 14, 
		RULE_atom = 15, RULE_not = 16, RULE_and = 17, RULE_or = 18, RULE_probability = 19, 
		RULE_fraction = 20, RULE_floatingpoint = 21;
	public static final String[] ruleNames = {
		"init", "signature", "variable", "binaryVar", "multivaluedVar", "varName", 
		"varValue", "conditionals", "conditionalSet", "conditional", "conditionalSetName", 
		"formula", "orexpression", "andexpression", "notexpression", "atom", "not", 
		"and", "or", "probability", "fraction", "floatingpoint"
	};

	@Override
	public String getGrammarFileName() { return "PCL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InitContext extends ParserRuleContext {
		public ConditionalsContext conditionals() {
			return getRuleContext(ConditionalsContext.class,0);
		}
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); signature();
			setState(45); conditionals();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignatureContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(15);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48); variable();
				setState(50);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(49); match(3);
					}
				}

				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public BinaryVarContext binaryVar() {
			return getRuleContext(BinaryVarContext.class,0);
		}
		public MultivaluedVarContext multivaluedVar() {
			return getRuleContext(MultivaluedVarContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); binaryVar();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); multivaluedVar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryVarContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public BinaryVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitBinaryVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryVarContext binaryVar() throws RecognitionException {
		BinaryVarContext _localctx = new BinaryVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_binaryVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); varName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultivaluedVarContext extends ParserRuleContext {
		public List<VarValueContext> varValue() {
			return getRuleContexts(VarValueContext.class);
		}
		public VarValueContext varValue(int i) {
			return getRuleContext(VarValueContext.class,i);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public MultivaluedVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multivaluedVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitMultivaluedVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultivaluedVarContext multivaluedVar() throws RecognitionException {
		MultivaluedVarContext _localctx = new MultivaluedVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multivaluedVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); varName();
			setState(63); match(12);
			setState(64); varValue();
			setState(65); match(3);
			setState(66); varValue();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(67); match(3);
				setState(68); varValue();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74); match(16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PCLParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PCLParser.ID, 0); }
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitVarValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalsContext extends ParserRuleContext {
		public List<ConditionalSetContext> conditionalSet() {
			return getRuleContexts(ConditionalSetContext.class);
		}
		public ConditionalSetContext conditionalSet(int i) {
			return getRuleContext(ConditionalSetContext.class,i);
		}
		public ConditionalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitConditionals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalsContext conditionals() throws RecognitionException {
		ConditionalsContext _localctx = new ConditionalsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(14);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(81); conditionalSet();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalSetContext extends ParserRuleContext {
		public ConditionalSetNameContext conditionalSetName() {
			return getRuleContext(ConditionalSetNameContext.class,0);
		}
		public ConditionalContext conditional(int i) {
			return getRuleContext(ConditionalContext.class,i);
		}
		public List<ConditionalContext> conditional() {
			return getRuleContexts(ConditionalContext.class);
		}
		public ConditionalSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitConditionalSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalSetContext conditionalSet() throws RecognitionException {
		ConditionalSetContext _localctx = new ConditionalSetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_conditionalSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); conditionalSetName();
			setState(88); match(12);
			setState(89); conditional();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(90); match(3);
				setState(91); conditional();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97); match(16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalWithProbabilityContext extends ConditionalContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public ConditionalWithProbabilityContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitConditionalWithProbability(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalWithoutProbabilityContext extends ConditionalContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ConditionalWithoutProbabilityContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitConditionalWithoutProbability(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormulaWithProbabilityContext extends ConditionalContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public FormulaWithProbabilityContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFormulaWithProbability(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormulaWithoutProbabilityContext extends ConditionalContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FormulaWithoutProbabilityContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFormulaWithoutProbability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditional);
		try {
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new FormulaWithoutProbabilityContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99); match(9);
				setState(100); formula();
				setState(101); match(2);
				}
				break;

			case 2:
				_localctx = new FormulaWithProbabilityContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(9);
				setState(104); formula();
				setState(105); match(2);
				setState(106); match(5);
				setState(107); probability();
				setState(108); match(1);
				}
				break;

			case 3:
				_localctx = new ConditionalWithoutProbabilityContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(110); match(9);
				setState(111); formula();
				setState(112); match(17);
				setState(113); formula();
				setState(114); match(2);
				}
				break;

			case 4:
				_localctx = new ConditionalWithProbabilityContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116); match(9);
				setState(117); formula();
				setState(118); match(17);
				setState(119); formula();
				setState(120); match(2);
				setState(121); match(5);
				setState(122); probability();
				setState(123); match(1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalSetNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PCLParser.ID, 0); }
		public ConditionalSetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalSetName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitConditionalSetName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalSetNameContext conditionalSetName() throws RecognitionException {
		ConditionalSetNameContext _localctx = new ConditionalSetNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conditionalSetName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public OrexpressionContext orexpression() {
			return getRuleContext(OrexpressionContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); orexpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrexpressionContext extends ParserRuleContext {
		public List<AndexpressionContext> andexpression() {
			return getRuleContexts(AndexpressionContext.class);
		}
		public AndexpressionContext andexpression(int i) {
			return getRuleContext(AndexpressionContext.class,i);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public OrexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitOrexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrexpressionContext orexpression() throws RecognitionException {
		OrexpressionContext _localctx = new OrexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_orexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); andexpression();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 11))) != 0)) {
				{
				{
				setState(132); or();
				setState(133); andexpression();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndexpressionContext extends ParserRuleContext {
		public List<NotexpressionContext> notexpression() {
			return getRuleContexts(NotexpressionContext.class);
		}
		public NotexpressionContext notexpression(int i) {
			return getRuleContext(NotexpressionContext.class,i);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public AndexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitAndexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexpressionContext andexpression() throws RecognitionException {
		AndexpressionContext _localctx = new AndexpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_andexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); notexpression();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 13))) != 0)) {
				{
				{
				setState(141); and();
				setState(142); notexpression();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotexpressionContext extends ParserRuleContext {
		public NotexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notexpression; }
	 
		public NotexpressionContext() { }
		public void copyFrom(NotexpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotAtomContext extends NotexpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public NotAtomContext(NotexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitNotAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleAtomContext extends NotexpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SingleAtomContext(NotexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitSingleAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotexpressionContext notexpression() throws RecognitionException {
		NotexpressionContext _localctx = new NotexpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_notexpression);
		try {
			setState(153);
			switch (_input.LA(1)) {
			case 8:
			case 18:
				_localctx = new NotAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149); not();
				setState(150); atom();
				}
				break;
			case 9:
			case ID:
				_localctx = new SingleAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormulaInBracketsContext extends AtomContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FormulaInBracketsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFormulaInBrackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomWithoutAllocContext extends AtomContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public AtomWithoutAllocContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitAtomWithoutAlloc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomWithAllocContext extends AtomContext {
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public AtomWithAllocContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitAtomWithAlloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atom);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new AtomWithoutAllocContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155); varName();
				}
				break;

			case 2:
				_localctx = new AtomWithAllocContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156); varName();
				setState(157); match(10);
				setState(158); varValue();
				}
				break;

			case 3:
				_localctx = new FormulaInBracketsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160); match(9);
				setState(161); formula();
				setState(162); match(2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_not);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==18) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 13))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProbabilityContext extends ParserRuleContext {
		public FloatingpointContext floatingpoint() {
			return getRuleContext(FloatingpointContext.class,0);
		}
		public FractionContext fraction() {
			return getRuleContext(FractionContext.class,0);
		}
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitProbability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_probability);
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); floatingpoint();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173); fraction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FractionContext extends ParserRuleContext {
		public TerminalNode FRACTIONSYMBOL() { return getToken(PCLParser.FRACTIONSYMBOL, 0); }
		public TerminalNode NUMBER(int i) {
			return getToken(PCLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(PCLParser.NUMBER); }
		public FractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FractionContext fraction() throws RecognitionException {
		FractionContext _localctx = new FractionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176); match(NUMBER);
			setState(177); match(FRACTIONSYMBOL);
			setState(178); match(NUMBER);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatingpointContext extends ParserRuleContext {
		public TerminalNode NUMBER(int i) {
			return getToken(PCLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(PCLParser.NUMBER); }
		public TerminalNode DECIMALMARK() { return getToken(PCLParser.DECIMALMARK, 0); }
		public FloatingpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingpoint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCLVisitor ) return ((PCLVisitor<? extends T>)visitor).visitFloatingpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingpointContext floatingpoint() throws RecognitionException {
		FloatingpointContext _localctx = new FloatingpointContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_floatingpoint);
		int _la;
		try {
			setState(187);
			switch (_input.LA(1)) {
			case DECIMALMARK:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(180); match(DECIMALMARK);
				setState(181); match(NUMBER);
				}
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); match(NUMBER);
				setState(185);
				_la = _input.LA(1);
				if (_la==DECIMALMARK) {
					{
					setState(183); match(DECIMALMARK);
					setState(184); match(NUMBER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\32\u00c0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\5\3\65\n\3\6\3\67\n\3\r\3\16\38\3\4\3\4\5\4=\n\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\7\tU\n\t\f\t\16\tX\13\t\3\n\3\n\3\n\3\n\3\n\7\n_\n\n\f\n\16\nb"+
		"\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0080\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u008a\n\16"+
		"\f\16\16\16\u008d\13\16\3\17\3\17\3\17\3\17\7\17\u0093\n\17\f\17\16\17"+
		"\u0096\13\17\3\20\3\20\3\20\3\20\5\20\u009c\n\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00a7\n\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\5\25\u00b1\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00bc\n\27\5\27\u00be\n\27\3\27\2\30\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,\2\5\4\2\n\n\24\24\5\2\5\5\b\b\17\17\5\2\6\6\t\t\r"+
		"\r\u00ba\2.\3\2\2\2\4\61\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fN\3"+
		"\2\2\2\16P\3\2\2\2\20R\3\2\2\2\22Y\3\2\2\2\24\177\3\2\2\2\26\u0081\3\2"+
		"\2\2\30\u0083\3\2\2\2\32\u0085\3\2\2\2\34\u008e\3\2\2\2\36\u009b\3\2\2"+
		"\2 \u00a6\3\2\2\2\"\u00a8\3\2\2\2$\u00aa\3\2\2\2&\u00ac\3\2\2\2(\u00b0"+
		"\3\2\2\2*\u00b2\3\2\2\2,\u00bd\3\2\2\2./\5\4\3\2/\60\5\20\t\2\60\3\3\2"+
		"\2\2\61\66\7\21\2\2\62\64\5\6\4\2\63\65\7\5\2\2\64\63\3\2\2\2\64\65\3"+
		"\2\2\2\65\67\3\2\2\2\66\62\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29"+
		"\5\3\2\2\2:=\5\b\5\2;=\5\n\6\2<:\3\2\2\2<;\3\2\2\2=\7\3\2\2\2>?\5\f\7"+
		"\2?\t\3\2\2\2@A\5\f\7\2AB\7\16\2\2BC\5\16\b\2CD\7\5\2\2DI\5\16\b\2EF\7"+
		"\5\2\2FH\5\16\b\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI"+
		"\3\2\2\2LM\7\22\2\2M\13\3\2\2\2NO\7\30\2\2O\r\3\2\2\2PQ\7\30\2\2Q\17\3"+
		"\2\2\2RV\7\20\2\2SU\5\22\n\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W"+
		"\21\3\2\2\2XV\3\2\2\2YZ\5\26\f\2Z[\7\16\2\2[`\5\24\13\2\\]\7\5\2\2]_\5"+
		"\24\13\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2"+
		"cd\7\22\2\2d\23\3\2\2\2ef\7\13\2\2fg\5\30\r\2gh\7\4\2\2h\u0080\3\2\2\2"+
		"ij\7\13\2\2jk\5\30\r\2kl\7\4\2\2lm\7\7\2\2mn\5(\25\2no\7\3\2\2o\u0080"+
		"\3\2\2\2pq\7\13\2\2qr\5\30\r\2rs\7\23\2\2st\5\30\r\2tu\7\4\2\2u\u0080"+
		"\3\2\2\2vw\7\13\2\2wx\5\30\r\2xy\7\23\2\2yz\5\30\r\2z{\7\4\2\2{|\7\7\2"+
		"\2|}\5(\25\2}~\7\3\2\2~\u0080\3\2\2\2\177e\3\2\2\2\177i\3\2\2\2\177p\3"+
		"\2\2\2\177v\3\2\2\2\u0080\25\3\2\2\2\u0081\u0082\7\30\2\2\u0082\27\3\2"+
		"\2\2\u0083\u0084\5\32\16\2\u0084\31\3\2\2\2\u0085\u008b\5\34\17\2\u0086"+
		"\u0087\5&\24\2\u0087\u0088\5\34\17\2\u0088\u008a\3\2\2\2\u0089\u0086\3"+
		"\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\33\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0094\5\36\20\2\u008f\u0090\5$\23"+
		"\2\u0090\u0091\5\36\20\2\u0091\u0093\3\2\2\2\u0092\u008f\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\35\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\5\"\22\2\u0098\u0099\5 \21\2\u0099"+
		"\u009c\3\2\2\2\u009a\u009c\5 \21\2\u009b\u0097\3\2\2\2\u009b\u009a\3\2"+
		"\2\2\u009c\37\3\2\2\2\u009d\u00a7\5\f\7\2\u009e\u009f\5\f\7\2\u009f\u00a0"+
		"\7\f\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a7\3\2\2\2\u00a2\u00a3\7\13\2\2"+
		"\u00a3\u00a4\5\30\r\2\u00a4\u00a5\7\4\2\2\u00a5\u00a7\3\2\2\2\u00a6\u009d"+
		"\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7!\3\2\2\2\u00a8"+
		"\u00a9\t\2\2\2\u00a9#\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab%\3\2\2\2\u00ac"+
		"\u00ad\t\4\2\2\u00ad\'\3\2\2\2\u00ae\u00b1\5,\27\2\u00af\u00b1\5*\26\2"+
		"\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1)\3\2\2\2\u00b2\u00b3\7"+
		"\27\2\2\u00b3\u00b4\7\25\2\2\u00b4\u00b5\7\27\2\2\u00b5+\3\2\2\2\u00b6"+
		"\u00b7\7\26\2\2\u00b7\u00be\7\27\2\2\u00b8\u00bb\7\27\2\2\u00b9\u00ba"+
		"\7\26\2\2\u00ba\u00bc\7\27\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2"+
		"\u00bc\u00be\3\2\2\2\u00bd\u00b6\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be-\3"+
		"\2\2\2\20\648<IV`\177\u008b\u0094\u009b\u00a6\u00b0\u00bb\u00bd";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}