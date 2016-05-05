package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLLexer;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser;

/**
 * This class represents a reader for reading and parsing strings or files.
 * 
 * @author koecher
 * 
 * @param <SORT>
 * @param <CONSTANT>
 * @param <VARIABLE>
 * @param <PREDICATE>
 * @param <CONDITIONAL>
 */
public abstract class AbstractReader<SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL>
		implements IReader<SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL> {
	private IVisitor<SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL> visitor;

	public AbstractReader(
			IVisitor<SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL> visitor) {
		this.visitor = visitor;
	}

	/**
	 * Reads logic from a string;
	 */
	public void readFromString(String s) {
		read(new ByteArrayInputStream(s.getBytes()));
	}
	
	/**
	 * Reads only conditionals from a string;
	 */
	public void readConditionalsFromString(String s) {
		readConditionals(new ByteArrayInputStream(s.getBytes()));
	}

	/**
	 * Reads logic from a path
	 */
	@Override
	public void read(String path) {
		read(new File(path));
	}

	/**
	 * Reads logic from a file
	 */
	@Override
	public void read(File file) {
		try {
			read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads logic from an InputStream
	 */
	@Override
	public void read(InputStream in) {
		ANTLRInputStream input;
		Scanner scanner = new Scanner(in);
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		input = new ANTLRInputStream(content);
		RCLLexer lexer = new RCLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RCLParser parser = new RCLParser(tokens);

		// Start rule is init
		ParseTree tree = parser.init();
		visitor.visitTree(tree);
	}

	/**
	 * Reads only Conditionals
	 * 
	 * @param conditionalInput
	 */
	public void readConditionals(InputStream conditionalInput) {
		ANTLRInputStream input;
		Scanner scanner = new Scanner(conditionalInput);
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		input = new ANTLRInputStream(content);
		RCLLexer lexer = new RCLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RCLParser parser = new RCLParser(tokens);

		ParseTree tree = parser.knowledge_base_body();
		visitor.visitTree(tree);
	}

	
	/**
	 * Returns sorts.
	 */
	@Override
	public Collection<SORT> getSorts() {
		Collection<SORT> sorts = new ArrayList<SORT>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		sorts.addAll(visitor.getSorts().values());
		return sorts;
	}

	
	/**
	 * Returns constants.
	 */
	@Override
	public Collection<CONSTANT> getConstants() {
		Collection<CONSTANT> constants = new ArrayList<CONSTANT>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		constants.addAll(visitor.getConstants().values());
		return constants;
	}

	
	/**
	 * Returns variables.
	 */
	@Override
	public Collection<VARIABLE> getVariables() {
		Collection<VARIABLE> variables = new ArrayList<VARIABLE>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		variables.addAll(visitor.getVariables().values());
		return variables;
	}

	
	/**
	 * Returns predicates.
	 */
	@Override
	public Collection<PREDICATE> getPredicates() {
		Collection<PREDICATE> predicates = new ArrayList<PREDICATE>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		predicates.addAll(visitor.getPredicates().values());
		return predicates;
	}

	/**
	 * Returns all conditionals from all knowledge bases.
	 */
	@Override
	public Collection<CONDITIONAL> getConditionals() {
		Collection<CONDITIONAL> conditionals = new ArrayList<CONDITIONAL>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		conditionals.addAll(visitor.getConditionals().values());
		return conditionals;
	}

	/**
	 * Returns knowledge bases.
	 */
	@Override
	public Map<String, Collection<CONDITIONAL>> getKnowledgeBases() {
		return visitor.getKnowledgeBases();
	}

	/**
	 * Returns a collection of conditionals to which the specified knowledgeBase
	 * is mapped or null if it is not defined.
	 */
	@Override
	public Collection<CONDITIONAL> getKnowledgeBase(String knowledgeBase) {
		Map<String, Collection<CONDITIONAL>> conditionals = visitor
				.getKnowledgeBases();
		if (conditionals.containsKey(knowledgeBase)) {
			return visitor.getKnowledgeBases().get(knowledgeBase);
		} else {
			elementNotDefined("Knowledge Base", knowledgeBase);
		}
		return null;
	}

	protected void elementNotDefined(String type, String element) {
		throw new IllegalArgumentException(type + " " + element
				+ " is not defined!");
	}

	/**
	 * Returns the variable object to which the specified varName is mapped or
	 * null if it is not defined.
	 */
	public VARIABLE getVariable(String varName) {
		Map<String, VARIABLE> variables = visitor.getVariables();
		if (variables.containsKey(varName)) {
			return variables.get(varName);
		} else {
			elementNotDefined("Variable", varName);
		}
		return null;
	}

	/**
	 * Returns the constant object to which the specified consName is mapped or
	 * null if it is not defined.
	 */
	public CONSTANT getConstant(String consName) {
		Map<String, CONSTANT> constants = visitor.getConstants();
		if (constants.containsKey(consName)) {
			return constants.get(consName);
		} else {
			elementNotDefined("Constant", consName);
		}
		return null;
	}

	/**
	 * Returns the predicate object to which the specified predName is mapped or
	 * null if it is not defined.
	 */
	public PREDICATE getPredicate(String predName) {
		Map<String, PREDICATE> predicates = visitor.getPredicates();
		if (predicates.containsKey(predName)) {
			return predicates.get(predName);
		} else {
			elementNotDefined("Predicate", predName);
		}
		return null;
	}

	/**
	 * Returns the sort object to which the specified sortName is mapped or null
	 * if it is not defined.
	 */
	public SORT getSort(String sortName) {
		Map<String, SORT> sorts = visitor.getSorts();
		if (sorts.containsKey(sortName)) {
			return sorts.get(sortName);
		} else {
			elementNotDefined("Sort", sortName);
		}
		return null;
	}

}
