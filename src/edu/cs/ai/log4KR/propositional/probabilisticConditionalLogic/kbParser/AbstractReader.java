package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser;

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

import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLLexer;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser;

/**
 * This class provides reading functions for propositional logic files. Please extend to use your data structures.
 * @author koecher
 *
 * @param <V> Multivalued Variable
 * @param <C> Conditional
 */

public abstract class AbstractReader<V, C> implements IReader<V, C>{
	
	private IVisitor<V, C> visitor;
	
	public AbstractReader(IVisitor<V, C> visitor) {
		this.visitor = visitor;
	}
	
	
	/**
	 * Reads logic from a string.
	 * @param s
	 */
	public void readFromString(String s){
		read(new ByteArrayInputStream(s.getBytes()));
	}
	
	/**
	 * Reads logic form a path.
	 */
	@Override
	public void read(String path) {
		read(new File(path));
	}

	/**
	 * Reads logic from a file.
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
	 * Reads logic from an InputStream.
	 */
	@Override
	public void read(InputStream in) {
		ANTLRInputStream input;
		Scanner scanner = new Scanner(in);
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		input = new ANTLRInputStream(content);
		PCLLexer lexer = new PCLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PCLParser parser = new PCLParser(tokens);

		ParseTree tree = parser.init();
		visitor.visitTree(tree);
	}

	/**
	 * Returns all variables.
	 */
	@Override
	public Collection<V> getVariables() {
		Collection<V> variables = new ArrayList<V>();
		//Can't just return the values of the map, because this collection doesn't support the add function!
		variables.addAll(visitor.getVariables().values());
		return variables;
	}

	/**
	 * Returns variable object by its name.
	 */
	@Override
	public V getVariable(String name) {
		return visitor.getVariables().get(name);
	}

	/**
	 * Returns collection of conditionals by its name.
	 */
	@Override
	public Collection<C> getKnowledgeBase(String name) {
		return visitor.getKnowledgeBases().get(name);
	}

	/**
	 * Returns all knowledge bases.
	 */
	@Override
	public Map<String, Collection<C>> getKnowledgeBases() {
		return visitor.getKnowledgeBases();
	}

}
