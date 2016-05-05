package edu.cs.ai.log4KR.util.parser.commandParser;

import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.cs.ai.log4KR.structuredLogics.reasoning.OptimumEntropyEpistemicStateLBFGS;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsBaseVisitor;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsLexer;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.FunctionNameContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.GlobalFunctionCallContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ObjectContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ObjectFunctionCallContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ObjectInitalizationContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ParameterContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ParametersContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.TypeContext;

/**
 * This class extends the {@link Log4KRCommandsBaseVisitor} class, which was created by antlr4.
 * General commands are implemented in the methods {@link #visitObjectInitalization(ObjectInitalizationContext)},
 * {@link #visitObjectFunctionCall(ObjectFunctionCallContext)} and {@link #visitGlobalFunctionCall(GlobalFunctionCallContext)}.
 * <br><br>
 * For implementing special commands (for relational or propositional) extend this class and override the abstract methods.
 * The recommended way is to use a switch case statement. Don't forget to check if objects are null and use {@link #errorHandle(ParserRuleContext, String)}
 * if they are.
 * @author koecher
 *
 * @param <EPS>
 */
public abstract class CommandVisitor <EPS extends OptimumEntropyEpistemicStateLBFGS<?>> extends Log4KRCommandsBaseVisitor<Void>{
	/**
	 * Is used for showing the error line in {@link #errorHandle(ParserRuleContext, String)}.
	 */
	protected String code;
	protected Map<String, EPS> epstates;
	
	public CommandVisitor() {
		this.code = "";
		this.epstates = new LinkedHashMap<String, EPS>();
	}
	
	public Map<String, EPS> getEpStates() {
		return epstates;
	}

	public void visitTree(String content) {
		code = content;
		ANTLRInputStream input = new ANTLRInputStream(content);
		Log4KRCommandsLexer lexer = new Log4KRCommandsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Log4KRCommandsParser parser = new Log4KRCommandsParser(tokens);

		// Start rule is init
		ParseTree tree = parser.init();
		visit(tree);
	}
	
	@Override
	public Void visitObjectInitalization(ObjectInitalizationContext ctx) {
		
		if(ctx.object() == null){
			errorHandle(ctx, "Object is not defined!");
		}
		
		if(ctx.type() == null){
			errorHandle(ctx, "Type is not defined!");
		}
		
		ObjectContext obj = ctx.object();
		TypeContext type = ctx.type();
		ParametersContext params = ctx.parameters();
		
		switch(ctx.type().getText()){

		default: specialObjectInitialization(obj, type, params);
		
		}
		return null;
	}
	
	@Override
	public Void visitObjectFunctionCall(ObjectFunctionCallContext ctx) {
		
		if(ctx.object() == null){
			errorHandle(ctx, "Object is not defined!");
		}
		
		if(ctx.function() == null){
			errorHandle(ctx, "Function is not defined!");
		}
		
		ObjectContext obj = ctx.object();
		FunctionNameContext function = ctx.function().functionName();
		ParametersContext params = ctx.function().parameters();
		
		switch(ctx.function().functionName().getText()){
		
		case "generalObjectFunctionCallTest":
			if(epstates.containsKey(ctx.object().getText())){
				System.out.println(epstates.get(ctx.object().getText()));
			}
			break;
			
		default: specialObjectFunctionCall(obj, function, params);
		
		}
		return null;
	}
	
	@Override
	public Void visitGlobalFunctionCall(GlobalFunctionCallContext ctx) {
		
		if(ctx.function() == null){
			errorHandle(ctx, "Function is not defined!");
		}
		
		FunctionNameContext function = ctx.function().functionName();
		ParametersContext params = ctx.function().parameters();
		
		switch (ctx.function().functionName().getText()) {

		default: specialGlobalFunctionCall(function, params);
		
		}
		return null;
	}

	/**
	 * To let the user declare objects, override this method.
	 * 
	 * @param obj Use .getText() to get the string which should represent the object later.
	 * @param type Use .getText() to differentiate between various types.
	 * @param params Use params.parameter() to get a list of {@link ParameterContext}. Or use
	 *               params.parameter(int) to get a specific {@link ParameterContext}.
	 *               The .getText() method returns the string that is written in the script.
	 */
	public abstract void specialObjectInitialization(ObjectContext obj, TypeContext type, ParametersContext params);
	
	/**
	 * Override this method, to let the user use object functions.
	 * 
	 * @param obj Use .getText() to get the string which represents the object.
	 * @param function Use .getText() to get the function name as string.
	 * @param params Use params.parameter() to get a list of {@link ParameterContext}. Or use
	 *               params.parameter(int) to get a specific {@link ParameterContext}.
	 *               The .getText() method returns the string that is written in the script.
	 */
	public abstract void specialObjectFunctionCall(ObjectContext obj, FunctionNameContext function, ParametersContext params);
	
	/**
	 * Override this method, to let the user use global functions.
	 * @param function Use .getText() to get the function name as string.
	 * @param params Use params.parameter() to get a list of {@link ParameterContext}. Or use
	 *               params.parameter(int) to get a specific {@link ParameterContext}.
	 *               The .getText() method returns the string that is written in the script.
	 */
	public abstract void specialGlobalFunctionCall(FunctionNameContext function, ParametersContext params);
	
	/**
	 * Throws IllegalArgumentException and displays the line of the error and a message.
	 * @param ctx The ParserRuleContext which is incorrect.
	 * @param message The message which should explain the error.
	 */
	protected void errorHandle(ParserRuleContext ctx, String message) {

		if(ctx != null){
			message += "\n\n";
			message += "At line:" + ctx.getStart().getLine() + " char:" + ctx.getStart().getCharPositionInLine();
			message += "\n\nLine\n";
			
			String [] codeLines = code.split("\n");
			
			////////// The following code is for displaying the right error line and pointing to the char where it begins.
			
			//Lines start at index 1
			if(ctx.getStart().getLine()-1 > 0){
				message += ctx.getStart().getLine()-1 + "\t" + codeLines[ctx.getStart().getLine()-2] + "\n";
			}
			
			
			for(int errLine = ctx.getStart().getLine(); errLine <= ctx.getStop().getLine(); errLine++){
				message += errLine + "\t" + codeLines[errLine-1] + "\n\t";
				if(errLine == ctx.getStart().getLine()){
					for(int i = 0; i < ctx.getStart().getCharPositionInLine(); i++){
						message += " ";
					}
	
					if(errLine == ctx.getStop().getLine()){
						for(int i = ctx.getStart().getCharPositionInLine(); i <= ctx.getStop().getCharPositionInLine(); i++){
							message += "^";
						}
					} else {
						for(int i = ctx.getStart().getCharPositionInLine(); i < codeLines[errLine-1].length(); i++){
							message += "^";
						}
					}
				} else if(errLine == ctx.getStop().getLine()){
					for(int i = 0; i <= ctx.getStop().getCharPositionInLine(); i++){
						message += "^";
					}
				} else {
					for(int i = 0; i < codeLines[errLine-1].length(); i++){
						message += "^";
					}
				}
				message += "\n";
			}
			
			if(ctx.getStop().getLine() < codeLines.length){
				message += (ctx.getStop().getLine()+1) + "\t" + codeLines[ctx.getStop().getLine()] + "\n";
			}

		}

		throw new IllegalArgumentException(message);
	}
}
