package edu.cs.ai.log4KR.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Sort;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * Utility class to generate latex documents.
 * Call init() to initialize document
 * and call close() to finish the string.
 * 
 * @author NicoPotyka, Henriette Fuss
 *
 */
public class LatexWriter {

	StringBuilder builder;
	
	
	public LatexWriter() {
		
	}
	
	
	
	public void init() {
		builder = new StringBuilder();
		builder.append("\\documentclass[a4paper,12pt]{article}\n");
		builder.append("\\usepackage{amsmath}\n ");
		builder.append("\\begin{document}\n");
	}
	
	public void close() {
		builder.append("\\end{document}\n");
	}
	
	public void printNewLineOfText(String s) {
		builder.append("\n"+s+"\n");
	}

	public void printPropositionalKnowledgeBase(Collection<Conditional<PropositionalVariable>> knowledgeBase) {

		printNewLineOfText("KnowledgeBase: ");
		builder.append("\\begin{align*} \n");
		for(Conditional<PropositionalVariable> cond: knowledgeBase) {
			String str = cond.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}

	public void printRelationalKnowledgeBase(Collection<RelationalConditional> knowledgeBase) {

		printNewLineOfText("KnowledgeBase: ");
		builder.append("\\begin{align*} \n");
		for(Conditional<RelationalAtom> cond: knowledgeBase) {
			String str = cond.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	
	public void printPredicates(Collection<Predicate> predicates) {

		printNewLineOfText("Predicates:");
		builder.append("\\begin{align*} \n");
		for(Predicate pred: predicates) {
			String str = pred.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	
	public void printConstants(Collection<Constant> constants) {

		printNewLineOfText("Constants:");
		builder.append("\\begin{align*} \n");
		for(Constant con: constants) {
			String str = con.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	
	public void printVariables(Collection<Variable> variables) {

		printNewLineOfText("Variables:");
		builder.append("\\begin{align*} \n");
		for(Variable var: variables) {
			String str = var.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	
	
	public void printSorts(Collection<Sort> sorts) {

		printNewLineOfText("Sorts:");
		builder.append("\\begin{align*} \n");
		for(Sort sor: sorts) {
			String str = sor.toString();
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	
	//print propositional variables
	public void printPropositionalVariables(Collection<PropositionalVariable> variables) {

		printNewLineOfText("Variables:");
		builder.append("\\begin{align*} \n");
		for(PropositionalVariable var: variables) {
			String str = var.toString();
			str = str.replace("{","= \\{");
			str = str.replace("}","\\}");
			builder.append("&"+str+"\\\\ \n");
		}
		builder.append("\\end{align*}\n");
	}
	

	
	@Override
	public String toString() {
		return builder.toString();
	}
	
	//Prints in TeX File
	public void printFile(String absolutePath, String text){
		FileWriter fw; 
		try{
			fw = new FileWriter(absolutePath);
			fw.write(text);
			fw.close();
		}
		catch(IOException e){ 
			System.err.println("Error in writing file: "+ absolutePath);
			System.err.println(e.toString());
		}
		
	}
	
}
