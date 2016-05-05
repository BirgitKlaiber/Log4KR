// Generated from Log4KRCommands.g4 by ANTLR 4.1

	package edu.cs.ai.log4KR.util.parser.commandParser.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Log4KRCommandsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Log4KRCommandsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull Log4KRCommandsParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#objectFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectFunctionCall(@NotNull Log4KRCommandsParser.ObjectFunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#objectInitalization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInitalization(@NotNull Log4KRCommandsParser.ObjectInitalizationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(@NotNull Log4KRCommandsParser.CommandContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#globalFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalFunctionCall(@NotNull Log4KRCommandsParser.GlobalFunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(@NotNull Log4KRCommandsParser.InitContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(@NotNull Log4KRCommandsParser.ObjectContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull Log4KRCommandsParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(@NotNull Log4KRCommandsParser.FunctionNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull Log4KRCommandsParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link Log4KRCommandsParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull Log4KRCommandsParser.FunctionContext ctx);
}