// Generated from PCL.g4 by ANTLR 4.1

	package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PCLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PCLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PCLParser#conditionals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionals(@NotNull PCLParser.ConditionalsContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#NotAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotAtom(@NotNull PCLParser.NotAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#SingleAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAtom(@NotNull PCLParser.SingleAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#FormulaWithProbability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaWithProbability(@NotNull PCLParser.FormulaWithProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#FormulaWithoutProbability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaWithoutProbability(@NotNull PCLParser.FormulaWithoutProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#conditionalSetName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalSetName(@NotNull PCLParser.ConditionalSetNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(@NotNull PCLParser.VarNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#floatingpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingpoint(@NotNull PCLParser.FloatingpointContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#varValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarValue(@NotNull PCLParser.VarValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#probability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbability(@NotNull PCLParser.ProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#andexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpression(@NotNull PCLParser.AndexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#conditionalSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalSet(@NotNull PCLParser.ConditionalSetContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(@NotNull PCLParser.SignatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#orexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpression(@NotNull PCLParser.OrexpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#multivaluedVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultivaluedVar(@NotNull PCLParser.MultivaluedVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(@NotNull PCLParser.FractionContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#ConditionalWithoutProbability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalWithoutProbability(@NotNull PCLParser.ConditionalWithoutProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull PCLParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(@NotNull PCLParser.InitContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull PCLParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull PCLParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#ConditionalWithProbability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalWithProbability(@NotNull PCLParser.ConditionalWithProbabilityContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#FormulaInBrackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaInBrackets(@NotNull PCLParser.FormulaInBracketsContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#binaryVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryVar(@NotNull PCLParser.BinaryVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#AtomWithoutAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomWithoutAlloc(@NotNull PCLParser.AtomWithoutAllocContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull PCLParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull PCLParser.FormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PCLParser#AtomWithAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomWithAlloc(@NotNull PCLParser.AtomWithAllocContext ctx);
}