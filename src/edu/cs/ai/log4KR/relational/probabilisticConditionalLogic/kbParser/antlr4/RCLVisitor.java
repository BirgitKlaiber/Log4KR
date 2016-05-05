// Generated from RCL.g4 by ANTLR 4.1

   package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RCLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RCLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RCLParser#conditionals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionals(@NotNull RCLParser.ConditionalsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#knowledge_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_base(@NotNull RCLParser.Knowledge_baseContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#NotAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotAtom(@NotNull RCLParser.NotAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#SingleAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAtom(@NotNull RCLParser.SingleAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#Fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(@NotNull RCLParser.FactContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#sort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSort(@NotNull RCLParser.SortContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#constraint_orexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_orexpression(@NotNull RCLParser.Constraint_orexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#InequalityConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequalityConstraint(@NotNull RCLParser.InequalityConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#knowledge_base_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_base_body(@NotNull RCLParser.Knowledge_base_bodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#constraint_andexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_andexpression(@NotNull RCLParser.Constraint_andexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#knowledge_bases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_bases(@NotNull RCLParser.Knowledge_basesContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#conditionals_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionals_body(@NotNull RCLParser.Conditionals_bodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull RCLParser.ConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#predicate_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_name(@NotNull RCLParser.Predicate_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#floatingpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingpoint(@NotNull RCLParser.FloatingpointContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#Cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(@NotNull RCLParser.CondContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#PredicateWithoutSorts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateWithoutSorts(@NotNull RCLParser.PredicateWithoutSortsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#PredicateWithTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateWithTerms(@NotNull RCLParser.PredicateWithTermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#probability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbability(@NotNull RCLParser.ProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#andexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpression(@NotNull RCLParser.AndexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(@NotNull RCLParser.SignatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#orexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpression(@NotNull RCLParser.OrexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(@NotNull RCLParser.FractionContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#SingleConstraintAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleConstraintAtom(@NotNull RCLParser.SingleConstraintAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull RCLParser.ConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull RCLParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#NotConstraintAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotConstraintAtom(@NotNull RCLParser.NotConstraintAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(@NotNull RCLParser.InitContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#ConstraintInBrackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintInBrackets(@NotNull RCLParser.ConstraintInBracketsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull RCLParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#sort_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSort_name(@NotNull RCLParser.Sort_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#knowledge_base_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_base_name(@NotNull RCLParser.Knowledge_base_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull RCLParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#PredicateWithoutTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateWithoutTerms(@NotNull RCLParser.PredicateWithoutTermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#variable_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_name(@NotNull RCLParser.Variable_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull RCLParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#FormulaInBrackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaInBrackets(@NotNull RCLParser.FormulaInBracketsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#PredicateWithSorts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateWithSorts(@NotNull RCLParser.PredicateWithSortsContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#EqualityConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityConstraint(@NotNull RCLParser.EqualityConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link RCLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull RCLParser.FormulaContext ctx);
}