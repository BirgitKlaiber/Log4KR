package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.cmdParser;

import java.util.ArrayList;
import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader;
import edu.cs.ai.log4KR.structuredLogics.reasoning.PropositionalOptimumEntropyEpistemicStateLBFGS;
import edu.cs.ai.log4KR.util.parser.commandParser.CommandVisitor;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.FunctionNameContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ObjectContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ParameterContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.ParametersContext;
import edu.cs.ai.log4KR.util.parser.commandParser.antlr4.Log4KRCommandsParser.TypeContext;

/**
 * All propositional commands are implemented in this class.
 * @author koecher
 *
 */

public class PropositionalCommandVisitor extends CommandVisitor<PropositionalOptimumEntropyEpistemicStateLBFGS>{

	Log4KRReader reader;
	PossibleWorldFactory<PropositionalVariable> worldFactory;

	public PropositionalCommandVisitor(PossibleWorldFactory<PropositionalVariable> worldFactory) {
		this(null, worldFactory);
	}
	
	public PropositionalCommandVisitor(Log4KRReader reader, PossibleWorldFactory<PropositionalVariable> worldFactory) {
		super();
		this.reader = reader;
		this.worldFactory = worldFactory;
	}

	@Override
	public void specialObjectInitialization(ObjectContext obj,
			TypeContext type, ParametersContext params) {
		switch(type.getText()){
		case "EPS":
		case "EpistemicState":
			epstates.put(obj.getText(), new PropositionalOptimumEntropyEpistemicStateLBFGS());
			break;
		default: errorHandle(type, "Object type " + type.getText() + " has not been implemented yet!");	
		}
	}
	
	@Override
	public void specialObjectFunctionCall(ObjectContext obj,
			FunctionNameContext function, ParametersContext params) {
		switch(function.getText()){
		
		// Initialize a knowledge base.
		// Object: epstate
		// Parameters: One or multiple knowledge bases
		case "init":
			if(epstates.containsKey(obj.getText())){
				Interpretation<PropositionalVariable>[] possibleWorlds = worldFactory.createPossibleWorlds(reader.getVariables());
				Collection<Conditional<PropositionalVariable>> kb = new ArrayList<Conditional<PropositionalVariable>>();
				for(ParameterContext param : params.parameter()){
					kb.addAll(reader.getKnowledgeBase(param.getText()));
				}
				epstates.get(obj.getText()).initialize(possibleWorlds, kb);
			} else {
				errorHandle(obj, "Epstate " + obj.getText() + " has not been defined!");
			}
			break;
			
		// Update an epstate with a knowledge base.
		// Object: epstate
		// Parameters: One or multiple knowledge bases. If multiple, they will be executed successively.
		case "update":
			if(epstates.containsKey(obj.getText())){
				if(params != null){
					for(ParameterContext param : params.parameter()){
						System.out.println("\n####Update epistemic state '" + obj.getText() + "' with knowledge base '" + param.getText() + "'####");
						epstates.get(obj.getText()).update(reader.getKnowledgeBase(param.getText()));
						System.out.println();
					}
				} else {
					errorHandle(function, function.getText() + " needs at least one parameter!");
				}
			} else {
				errorHandle(obj, "Epstate " + obj.getText() + " has not been defined!");
			}
			break;
			
		// Revise an epstate with a knowledge base.
		// Object: epstate
		// Parameters: One or multiple knowledge bases. If multiple, they will be executed successively.
		case "revise":
			if(epstates.containsKey(obj.getText())){
				if(params != null){
					for(ParameterContext param : params.parameter()){
						System.out.println("\n####Revise epistemic state '" + obj.getText() + "' with knowledge base '" + param.getText() + "'####");
						epstates.get(obj.getText()).revise(reader.getKnowledgeBase(param.getText()));
						System.out.println();
					}
				} else {
					errorHandle(function, function.getText() + " needs at least one parameter!");
				}
			} else {
				errorHandle(obj, "Epstate " + obj.getText() + " has not been defined!");
			}
			break;
			
		// Query the epstate with conditionals of a knowledge base.
		// Object: epstate
		// Parameters: One or multiple knowledge bases. If multiple, they will be executed successively.
		case "query":
			if(epstates.containsKey(obj.getText())){
				if(params != null){
					for(ParameterContext param : params.parameter()){
						System.out.println("\n####Query '" + param.getText() + "' on epistemic state '" + obj.getText() + "'####");
						System.out.println("Results:");
						for(Conditional<PropositionalVariable> cond : reader.getKnowledgeBase(param.getText())){
							System.out.println(cond + " = " + epstates.get(obj.getText()).query(cond));
						}
						System.out.println();
					}
				} else {
					errorHandle(function, function.getText() + " needs at least one parameter!");
				}
			} else {
				errorHandle(obj, "Epstate " + obj.getText() + " has not been defined!");
			}
			break;
		default: errorHandle(function, "Object function '" + function.getText() + "' has not been implemented yet!");
		}
	}

	@Override
	public void specialGlobalFunctionCall(FunctionNameContext function,
			ParametersContext params) {
		switch (function.getText()) {
		
		// Prints information about parameters on the screen
		// Parameters: Either a String, an epstate name, 'signature', 'conditionals' or 'reader'.
		case "print":
			if(params != null){
				for(ParameterContext param : params.parameter()){
					//If string then print it out, if not then search for it as objectvariable
					if(param.STRING() == null){
						if(epstates.containsKey(param.getText())){
							((PropositionalOptimumEntropyEpistemicStateLBFGS) epstates.get(param.getText())).printCurrentProbabilities();
						}
						
						else if(param.getText().equals("signature")) {
							System.out.println("signature");
							for(PropositionalVariable var : reader.getVariables()){
								System.out.println("\t" + var);
							}
						}
						
						else if(param.getText().equals("conditionals")) {
							System.out.println("conditionals");
							for(String kb : reader.getKnowledgeBases().keySet()){
								System.out.println(kb + "{");
								for(Conditional<?> cond : reader.getKnowledgeBase(kb)){
									System.out.println("\t" + cond);
								}
								System.out.println("}");
							}
						}
	
						
						else if(param.getText().equals("reader")) {
							System.out.println(reader);
						}
						
						else {
							errorHandle(param, "'" + param.getText() + "' coundn't be found!");
						}
					} else {
						System.out.println(param.getText().substring(1, param.getText().length()-1));
					}
				}
			} else {
				errorHandle(function, "'Print' needs at least one parameter!");
			}
			break;
		
		
		// Sets the reader if it is not set already.
		// Parameters: Path to the knowledge base file as string.
		case "use":
			if(params != null){
				if(reader == null){
					if(params.parameter(0).STRING() != null){
						String pathStr = params.parameter(0).getText();
						pathStr = pathStr.substring(1, pathStr.length()-1);
						reader = new Log4KRReader();
						reader.read(pathStr);
					} else {
						errorHandle(params, "Please enter path as string!");
					}
				} else {
					System.err.println("Warning: There is already an reader object, so the use command was not executed!");
				}
			} else {
				errorHandle(function, "'use' needs at least one parameter!");
			}
			break;

		default: errorHandle(function, "Global function '" + function.getText() + "' has not been implemented yet!");
		}
	}

}
