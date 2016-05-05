// Generated from RCL.g4 by ANTLR 4.1

   package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RCLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		NUMBER=25, ID=26, LINE_COMMENT=27, SKIP_LINES=28;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "'.'", "','", "'+'", "'['", "'*'", "'or'", 
		"'('", "'not'", "'<'", "'='", "'!='", "';'", "'>'", "'{'", "'and'", "'conditionals'", 
		"'signature'", "'=='", "'/'", "'}'", "'|'", "'!'", "NUMBER", "ID", "LINE_COMMENT", 
		"SKIP_LINES"
	};
	public static final int
		RULE_init = 0, RULE_signature = 1, RULE_sort = 2, RULE_predicate = 3, 
		RULE_conditionals = 4, RULE_conditionals_body = 5, RULE_knowledge_bases = 6, 
		RULE_knowledge_base = 7, RULE_knowledge_base_body = 8, RULE_conditional = 9, 
		RULE_formula = 10, RULE_orexpression = 11, RULE_andexpression = 12, RULE_notexpression = 13, 
		RULE_atom = 14, RULE_constraint = 15, RULE_constraint_orexpression = 16, 
		RULE_constraint_andexpression = 17, RULE_constraint_notexpression = 18, 
		RULE_constraint_atom = 19, RULE_knowledge_base_name = 20, RULE_sort_name = 21, 
		RULE_constant = 22, RULE_predicate_name = 23, RULE_variable_name = 24, 
		RULE_term = 25, RULE_and = 26, RULE_or = 27, RULE_not = 28, RULE_probability = 29, 
		RULE_fraction = 30, RULE_floatingpoint = 31;
	public static final String[] ruleNames = {
		"init", "signature", "sort", "predicate", "conditionals", "conditionals_body", 
		"knowledge_bases", "knowledge_base", "knowledge_base_body", "conditional", 
		"formula", "orexpression", "andexpression", "notexpression", "atom", "constraint", 
		"constraint_orexpression", "constraint_andexpression", "constraint_notexpression", 
		"constraint_atom", "knowledge_base_name", "sort_name", "constant", "predicate_name", 
		"variable_name", "term", "and", "or", "not", "probability", "fraction", 
		"floatingpoint"
	};

	@Override
	public String getGrammarFileName() { return "RCL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public RCLParser(TokenStream input) {
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); signature();
			setState(65); conditionals();
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
		public SortContext sort(int i) {
			return getRuleContext(SortContext.class,i);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public List<SortContext> sort() {
			return getRuleContexts(SortContext.class);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_signature);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(19);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(68); sort();
					setState(70);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(69); match(4);
						}
					}

					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(77); predicate();
				setState(79);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(78); match(4);
					}
				}

				}
				}
				setState(85);
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

	public static class SortContext extends ParserRuleContext {
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public SortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitSort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortContext sort() throws RecognitionException {
		SortContext _localctx = new SortContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sort);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); sort_name();
			setState(87); match(12);
			setState(88); match(16);
			setState(89); constant();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(90); match(4);
				setState(91); constant();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97); match(22);
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

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PredicateWithoutSortsContext extends PredicateContext {
		public Predicate_nameContext predicate_name() {
			return getRuleContext(Predicate_nameContext.class,0);
		}
		public PredicateWithoutSortsContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitPredicateWithoutSorts(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredicateWithSortsContext extends PredicateContext {
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public Predicate_nameContext predicate_name() {
			return getRuleContext(Predicate_nameContext.class,0);
		}
		public PredicateWithSortsContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitPredicateWithSorts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predicate);
		int _la;
		try {
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new PredicateWithoutSortsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99); predicate_name();
				setState(100); match(9);
				setState(101); match(2);
				}
				break;

			case 2:
				_localctx = new PredicateWithSortsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103); predicate_name();
				setState(104); match(9);
				setState(105); sort_name();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(106); match(4);
					setState(107); sort_name();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113); match(2);
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

	public static class ConditionalsContext extends ParserRuleContext {
		public Conditionals_bodyContext conditionals_body() {
			return getRuleContext(Conditionals_bodyContext.class,0);
		}
		public ConditionalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConditionals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalsContext conditionals() throws RecognitionException {
		ConditionalsContext _localctx = new ConditionalsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conditionals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(18);
			setState(118); conditionals_body();
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

	public static class Conditionals_bodyContext extends ParserRuleContext {
		public Knowledge_base_bodyContext knowledge_base_body() {
			return getRuleContext(Knowledge_base_bodyContext.class,0);
		}
		public Knowledge_basesContext knowledge_bases() {
			return getRuleContext(Knowledge_basesContext.class,0);
		}
		public Conditionals_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionals_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConditionals_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditionals_bodyContext conditionals_body() throws RecognitionException {
		Conditionals_bodyContext _localctx = new Conditionals_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditionals_body);
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120); knowledge_bases();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); knowledge_base_body();
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

	public static class Knowledge_basesContext extends ParserRuleContext {
		public Knowledge_baseContext knowledge_base(int i) {
			return getRuleContext(Knowledge_baseContext.class,i);
		}
		public List<Knowledge_baseContext> knowledge_base() {
			return getRuleContexts(Knowledge_baseContext.class);
		}
		public Knowledge_basesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_bases; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitKnowledge_bases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_basesContext knowledge_bases() throws RecognitionException {
		Knowledge_basesContext _localctx = new Knowledge_basesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_knowledge_bases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(124); knowledge_base();
				setState(126);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(125); match(4);
					}
				}

				}
				}
				setState(132);
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

	public static class Knowledge_baseContext extends ParserRuleContext {
		public Knowledge_base_bodyContext knowledge_base_body() {
			return getRuleContext(Knowledge_base_bodyContext.class,0);
		}
		public Knowledge_base_nameContext knowledge_base_name() {
			return getRuleContext(Knowledge_base_nameContext.class,0);
		}
		public Knowledge_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_base; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitKnowledge_base(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_baseContext knowledge_base() throws RecognitionException {
		Knowledge_baseContext _localctx = new Knowledge_baseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_knowledge_base);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); knowledge_base_name();
			setState(134); match(16);
			setState(135); knowledge_base_body();
			setState(136); match(22);
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

	public static class Knowledge_base_bodyContext extends ParserRuleContext {
		public ConditionalContext conditional(int i) {
			return getRuleContext(ConditionalContext.class,i);
		}
		public List<ConditionalContext> conditional() {
			return getRuleContexts(ConditionalContext.class);
		}
		public Knowledge_base_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_base_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitKnowledge_base_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_base_bodyContext knowledge_base_body() throws RecognitionException {
		Knowledge_base_bodyContext _localctx = new Knowledge_base_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_knowledge_base_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(138); conditional();
				setState(140);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(139); match(4);
					}
				}

				}
				}
				setState(146);
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
	public static class FactContext extends ConditionalContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public FactContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondContext extends ConditionalContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public CondContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditional);
		int _la;
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new FactContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(9);
				setState(148); formula();
				setState(149); match(2);
				setState(154);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(150); match(6);
					setState(151); probability();
					setState(152); match(1);
					}
				}

				setState(160);
				_la = _input.LA(1);
				if (_la==11) {
					{
					setState(156); match(11);
					setState(157); constraint();
					setState(158); match(15);
					}
				}

				}
				break;

			case 2:
				_localctx = new CondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162); match(9);
				setState(163); formula();
				setState(164); match(23);
				setState(165); formula();
				setState(166); match(2);
				setState(171);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(167); match(6);
					setState(168); probability();
					setState(169); match(1);
					}
				}

				setState(177);
				_la = _input.LA(1);
				if (_la==11) {
					{
					setState(173); match(11);
					setState(174); constraint();
					setState(175); match(15);
					}
				}

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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); orexpression();
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitOrexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrexpressionContext orexpression() throws RecognitionException {
		OrexpressionContext _localctx = new OrexpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_orexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); andexpression();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 8) | (1L << 14))) != 0)) {
				{
				{
				setState(184); or();
				setState(185); andexpression();
				}
				}
				setState(191);
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitAndexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexpressionContext andexpression() throws RecognitionException {
		AndexpressionContext _localctx = new AndexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_andexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); notexpression();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 17))) != 0)) {
				{
				{
				setState(193); and();
				setState(194); notexpression();
				}
				}
				setState(200);
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitNotAtom(this);
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitSingleAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotexpressionContext notexpression() throws RecognitionException {
		NotexpressionContext _localctx = new NotexpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_notexpression);
		try {
			setState(205);
			switch (_input.LA(1)) {
			case 10:
			case 24:
				_localctx = new NotAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(201); not();
				setState(202); atom();
				}
				break;
			case 9:
			case ID:
				_localctx = new SingleAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(204); atom();
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
	public static class PredicateWithoutTermsContext extends AtomContext {
		public Predicate_nameContext predicate_name() {
			return getRuleContext(Predicate_nameContext.class,0);
		}
		public PredicateWithoutTermsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitPredicateWithoutTerms(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormulaInBracketsContext extends AtomContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FormulaInBracketsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitFormulaInBrackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredicateWithTermsContext extends AtomContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public Predicate_nameContext predicate_name() {
			return getRuleContext(Predicate_nameContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public PredicateWithTermsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitPredicateWithTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new PredicateWithoutTermsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207); predicate_name();
				}
				break;

			case 2:
				_localctx = new PredicateWithTermsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208); predicate_name();
				setState(209); match(9);
				setState(210); term();
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(211); match(4);
					setState(212); term();
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(218); match(2);
				}
				break;

			case 3:
				_localctx = new FormulaInBracketsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(220); match(9);
				setState(221); formula();
				setState(222); match(2);
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

	public static class ConstraintContext extends ParserRuleContext {
		public Constraint_orexpressionContext constraint_orexpression() {
			return getRuleContext(Constraint_orexpressionContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); constraint_orexpression();
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

	public static class Constraint_orexpressionContext extends ParserRuleContext {
		public Constraint_andexpressionContext constraint_andexpression(int i) {
			return getRuleContext(Constraint_andexpressionContext.class,i);
		}
		public List<Constraint_andexpressionContext> constraint_andexpression() {
			return getRuleContexts(Constraint_andexpressionContext.class);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public Constraint_orexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_orexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConstraint_orexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_orexpressionContext constraint_orexpression() throws RecognitionException {
		Constraint_orexpressionContext _localctx = new Constraint_orexpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constraint_orexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); constraint_andexpression();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 8) | (1L << 14))) != 0)) {
				{
				{
				setState(229); or();
				setState(230); constraint_andexpression();
				}
				}
				setState(236);
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

	public static class Constraint_andexpressionContext extends ParserRuleContext {
		public Constraint_notexpressionContext constraint_notexpression(int i) {
			return getRuleContext(Constraint_notexpressionContext.class,i);
		}
		public List<Constraint_notexpressionContext> constraint_notexpression() {
			return getRuleContexts(Constraint_notexpressionContext.class);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public Constraint_andexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_andexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConstraint_andexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_andexpressionContext constraint_andexpression() throws RecognitionException {
		Constraint_andexpressionContext _localctx = new Constraint_andexpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constraint_andexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); constraint_notexpression();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 17))) != 0)) {
				{
				{
				setState(238); and();
				setState(239); constraint_notexpression();
				}
				}
				setState(245);
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

	public static class Constraint_notexpressionContext extends ParserRuleContext {
		public Constraint_notexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_notexpression; }
	 
		public Constraint_notexpressionContext() { }
		public void copyFrom(Constraint_notexpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleConstraintAtomContext extends Constraint_notexpressionContext {
		public Constraint_atomContext constraint_atom() {
			return getRuleContext(Constraint_atomContext.class,0);
		}
		public SingleConstraintAtomContext(Constraint_notexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitSingleConstraintAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotConstraintAtomContext extends Constraint_notexpressionContext {
		public Constraint_atomContext constraint_atom() {
			return getRuleContext(Constraint_atomContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public NotConstraintAtomContext(Constraint_notexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitNotConstraintAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_notexpressionContext constraint_notexpression() throws RecognitionException {
		Constraint_notexpressionContext _localctx = new Constraint_notexpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constraint_notexpression);
		try {
			setState(250);
			switch (_input.LA(1)) {
			case 10:
			case 24:
				_localctx = new NotConstraintAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246); not();
				setState(247); constraint_atom();
				}
				break;
			case 9:
			case ID:
				_localctx = new SingleConstraintAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249); constraint_atom();
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

	public static class Constraint_atomContext extends ParserRuleContext {
		public Constraint_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_atom; }
	 
		public Constraint_atomContext() { }
		public void copyFrom(Constraint_atomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InequalityConstraintContext extends Constraint_atomContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Variable_nameContext variable_name() {
			return getRuleContext(Variable_nameContext.class,0);
		}
		public InequalityConstraintContext(Constraint_atomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitInequalityConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintInBracketsContext extends Constraint_atomContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public ConstraintInBracketsContext(Constraint_atomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConstraintInBrackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityConstraintContext extends Constraint_atomContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Variable_nameContext variable_name() {
			return getRuleContext(Variable_nameContext.class,0);
		}
		public EqualityConstraintContext(Constraint_atomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitEqualityConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_atomContext constraint_atom() throws RecognitionException {
		Constraint_atomContext _localctx = new Constraint_atomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constraint_atom);
		try {
			setState(264);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new EqualityConstraintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252); variable_name();
				setState(253); match(20);
				setState(254); term();
				}
				break;

			case 2:
				_localctx = new InequalityConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256); variable_name();
				setState(257); match(13);
				setState(258); term();
				}
				break;

			case 3:
				_localctx = new ConstraintInBracketsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(260); match(9);
				setState(261); constraint();
				setState(262); match(2);
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

	public static class Knowledge_base_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public Knowledge_base_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_base_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitKnowledge_base_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_base_nameContext knowledge_base_name() throws RecognitionException {
		Knowledge_base_nameContext _localctx = new Knowledge_base_nameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_knowledge_base_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(ID);
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

	public static class Sort_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public Sort_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitSort_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sort_nameContext sort_name() throws RecognitionException {
		Sort_nameContext _localctx = new Sort_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sort_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(ID);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(ID);
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

	public static class Predicate_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public Predicate_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitPredicate_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_nameContext predicate_name() throws RecognitionException {
		Predicate_nameContext _localctx = new Predicate_nameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predicate_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(ID);
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

	public static class Variable_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public Variable_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitVariable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_nameContext variable_name() throws RecognitionException {
		Variable_nameContext _localctx = new Variable_nameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variable_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(ID);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RCLParser.ID, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); match(ID);
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 17))) != 0)) ) {
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 8) | (1L << 14))) != 0)) ) {
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

	public static class NotContext extends ParserRuleContext {
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_not);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==24) ) {
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
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitProbability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_probability);
		try {
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284); floatingpoint();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285); fraction();
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
		public TerminalNode NUMBER(int i) {
			return getToken(RCLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(RCLParser.NUMBER); }
		public FractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitFraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FractionContext fraction() throws RecognitionException {
		FractionContext _localctx = new FractionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_fraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(288); match(NUMBER);
			setState(289); match(21);
			setState(290); match(NUMBER);
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
			return getToken(RCLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(RCLParser.NUMBER); }
		public FloatingpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingpoint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RCLVisitor ) return ((RCLVisitor<? extends T>)visitor).visitFloatingpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingpointContext floatingpoint() throws RecognitionException {
		FloatingpointContext _localctx = new FloatingpointContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_floatingpoint);
		int _la;
		try {
			setState(299);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(292); match(3);
				setState(293); match(NUMBER);
				}
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(294); match(NUMBER);
				setState(297);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(295); match(3);
					setState(296); match(NUMBER);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\36\u0130\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\3\3\3\3\3\5\3I\n\3\7\3K\n\3\f\3\16\3N\13\3\3\3\3\3\5"+
		"\3R\n\3\7\3T\n\3\f\3\16\3W\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4_\n\4\f\4\16"+
		"\4b\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5o\n\5\f\5\16\5"+
		"r\13\5\3\5\3\5\5\5v\n\5\3\6\3\6\3\6\3\7\3\7\5\7}\n\7\3\b\3\b\5\b\u0081"+
		"\n\b\7\b\u0083\n\b\f\b\16\b\u0086\13\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n"+
		"\u008f\n\n\7\n\u0091\n\n\f\n\16\n\u0094\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u009d\n\13\3\13\3\13\3\13\3\13\5\13\u00a3\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ae\n\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00b4\n\13\5\13\u00b6\n\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00be"+
		"\n\r\f\r\16\r\u00c1\13\r\3\16\3\16\3\16\3\16\7\16\u00c7\n\16\f\16\16\16"+
		"\u00ca\13\16\3\17\3\17\3\17\3\17\5\17\u00d0\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u00d8\n\20\f\20\16\20\u00db\13\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00e3\n\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u00eb\n\22"+
		"\f\22\16\22\u00ee\13\22\3\23\3\23\3\23\3\23\7\23\u00f4\n\23\f\23\16\23"+
		"\u00f7\13\23\3\24\3\24\3\24\3\24\5\24\u00fd\n\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010b\n\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\5\37\u0121\n\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\5!\u012c\n"+
		"!\5!\u012e\n!\3!\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@\2\5\5\2\6\6\t\t\23\23\5\2\7\7\n\n\20\20\4\2\f\f\32\32\u012e"+
		"\2B\3\2\2\2\4E\3\2\2\2\6X\3\2\2\2\bu\3\2\2\2\nw\3\2\2\2\f|\3\2\2\2\16"+
		"\u0084\3\2\2\2\20\u0087\3\2\2\2\22\u0092\3\2\2\2\24\u00b5\3\2\2\2\26\u00b7"+
		"\3\2\2\2\30\u00b9\3\2\2\2\32\u00c2\3\2\2\2\34\u00cf\3\2\2\2\36\u00e2\3"+
		"\2\2\2 \u00e4\3\2\2\2\"\u00e6\3\2\2\2$\u00ef\3\2\2\2&\u00fc\3\2\2\2(\u010a"+
		"\3\2\2\2*\u010c\3\2\2\2,\u010e\3\2\2\2.\u0110\3\2\2\2\60\u0112\3\2\2\2"+
		"\62\u0114\3\2\2\2\64\u0116\3\2\2\2\66\u0118\3\2\2\28\u011a\3\2\2\2:\u011c"+
		"\3\2\2\2<\u0120\3\2\2\2>\u0122\3\2\2\2@\u012d\3\2\2\2BC\5\4\3\2CD\5\n"+
		"\6\2D\3\3\2\2\2EL\7\25\2\2FH\5\6\4\2GI\7\6\2\2HG\3\2\2\2HI\3\2\2\2IK\3"+
		"\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MU\3\2\2\2NL\3\2\2\2OQ\5"+
		"\b\5\2PR\7\6\2\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3"+
		"\2\2\2UV\3\2\2\2V\5\3\2\2\2WU\3\2\2\2XY\5,\27\2YZ\7\16\2\2Z[\7\22\2\2"+
		"[`\5.\30\2\\]\7\6\2\2]_\5.\30\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2"+
		"\2ac\3\2\2\2b`\3\2\2\2cd\7\30\2\2d\7\3\2\2\2ef\5\60\31\2fg\7\13\2\2gh"+
		"\7\4\2\2hv\3\2\2\2ij\5\60\31\2jk\7\13\2\2kp\5,\27\2lm\7\6\2\2mo\5,\27"+
		"\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7\4\2"+
		"\2tv\3\2\2\2ue\3\2\2\2ui\3\2\2\2v\t\3\2\2\2wx\7\24\2\2xy\5\f\7\2y\13\3"+
		"\2\2\2z}\5\16\b\2{}\5\22\n\2|z\3\2\2\2|{\3\2\2\2}\r\3\2\2\2~\u0080\5\20"+
		"\t\2\177\u0081\7\6\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083"+
		"\3\2\2\2\u0082~\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\5*\26"+
		"\2\u0088\u0089\7\22\2\2\u0089\u008a\5\22\n\2\u008a\u008b\7\30\2\2\u008b"+
		"\21\3\2\2\2\u008c\u008e\5\24\13\2\u008d\u008f\7\6\2\2\u008e\u008d\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008c\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\23\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0095\u0096\7\13\2\2\u0096\u0097\5\26\f\2\u0097"+
		"\u009c\7\4\2\2\u0098\u0099\7\b\2\2\u0099\u009a\5<\37\2\u009a\u009b\7\3"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u0098\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a2\3\2\2\2\u009e\u009f\7\r\2\2\u009f\u00a0\5 \21\2\u00a0\u00a1\7\21"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00b6\3\2\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\7"+
		"\31\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00ad\7\4\2\2\u00a9\u00aa\7\b\2\2\u00aa"+
		"\u00ab\5<\37\2\u00ab\u00ac\7\3\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b3\3\2\2\2\u00af\u00b0\7\r\2\2\u00b0"+
		"\u00b1\5 \21\2\u00b1\u00b2\7\21\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00af\3"+
		"\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u0095\3\2\2\2\u00b5"+
		"\u00a4\3\2\2\2\u00b6\25\3\2\2\2\u00b7\u00b8\5\30\r\2\u00b8\27\3\2\2\2"+
		"\u00b9\u00bf\5\32\16\2\u00ba\u00bb\58\35\2\u00bb\u00bc\5\32\16\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\31\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c8"+
		"\5\34\17\2\u00c3\u00c4\5\66\34\2\u00c4\u00c5\5\34\17\2\u00c5\u00c7\3\2"+
		"\2\2\u00c6\u00c3\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\33\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\5:\36"+
		"\2\u00cc\u00cd\5\36\20\2\u00cd\u00d0\3\2\2\2\u00ce\u00d0\5\36\20\2\u00cf"+
		"\u00cb\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\35\3\2\2\2\u00d1\u00e3\5\60\31"+
		"\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4\7\13\2\2\u00d4\u00d9\5\64\33\2\u00d5"+
		"\u00d6\7\6\2\2\u00d6\u00d8\5\64\33\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3"+
		"\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\7\4\2\2\u00dd\u00e3\3\2\2\2\u00de\u00df\7\13"+
		"\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\7\4\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00d1\3\2\2\2\u00e2\u00d2\3\2\2\2\u00e2\u00de\3\2\2\2\u00e3\37\3\2\2"+
		"\2\u00e4\u00e5\5\"\22\2\u00e5!\3\2\2\2\u00e6\u00ec\5$\23\2\u00e7\u00e8"+
		"\58\35\2\u00e8\u00e9\5$\23\2\u00e9\u00eb\3\2\2\2\u00ea\u00e7\3\2\2\2\u00eb"+
		"\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed#\3\2\2\2"+
		"\u00ee\u00ec\3\2\2\2\u00ef\u00f5\5&\24\2\u00f0\u00f1\5\66\34\2\u00f1\u00f2"+
		"\5&\24\2\u00f2\u00f4\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6%\3\2\2\2\u00f7\u00f5\3\2\2\2"+
		"\u00f8\u00f9\5:\36\2\u00f9\u00fa\5(\25\2\u00fa\u00fd\3\2\2\2\u00fb\u00fd"+
		"\5(\25\2\u00fc\u00f8\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\'\3\2\2\2\u00fe"+
		"\u00ff\5\62\32\2\u00ff\u0100\7\26\2\2\u0100\u0101\5\64\33\2\u0101\u010b"+
		"\3\2\2\2\u0102\u0103\5\62\32\2\u0103\u0104\7\17\2\2\u0104\u0105\5\64\33"+
		"\2\u0105\u010b\3\2\2\2\u0106\u0107\7\13\2\2\u0107\u0108\5 \21\2\u0108"+
		"\u0109\7\4\2\2\u0109\u010b\3\2\2\2\u010a\u00fe\3\2\2\2\u010a\u0102\3\2"+
		"\2\2\u010a\u0106\3\2\2\2\u010b)\3\2\2\2\u010c\u010d\7\34\2\2\u010d+\3"+
		"\2\2\2\u010e\u010f\7\34\2\2\u010f-\3\2\2\2\u0110\u0111\7\34\2\2\u0111"+
		"/\3\2\2\2\u0112\u0113\7\34\2\2\u0113\61\3\2\2\2\u0114\u0115\7\34\2\2\u0115"+
		"\63\3\2\2\2\u0116\u0117\7\34\2\2\u0117\65\3\2\2\2\u0118\u0119\t\2\2\2"+
		"\u0119\67\3\2\2\2\u011a\u011b\t\3\2\2\u011b9\3\2\2\2\u011c\u011d\t\4\2"+
		"\2\u011d;\3\2\2\2\u011e\u0121\5@!\2\u011f\u0121\5> \2\u0120\u011e\3\2"+
		"\2\2\u0120\u011f\3\2\2\2\u0121=\3\2\2\2\u0122\u0123\7\33\2\2\u0123\u0124"+
		"\7\27\2\2\u0124\u0125\7\33\2\2\u0125?\3\2\2\2\u0126\u0127\7\5\2\2\u0127"+
		"\u012e\7\33\2\2\u0128\u012b\7\33\2\2\u0129\u012a\7\5\2\2\u012a\u012c\7"+
		"\33\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u0126\3\2\2\2\u012d\u0128\3\2\2\2\u012eA\3\2\2\2\37HLQU`pu|\u0080\u0084"+
		"\u008e\u0092\u009c\u00a2\u00ad\u00b3\u00b5\u00bf\u00c8\u00cf\u00d9\u00e2"+
		"\u00ec\u00f5\u00fc\u010a\u0120\u012b\u012d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}