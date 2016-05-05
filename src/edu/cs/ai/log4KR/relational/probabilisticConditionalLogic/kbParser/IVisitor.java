package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser;

import java.util.Collection;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.ConditionalContext;
/**
 * 
 * @author koecher
 *
 * @param <SORT>
 * @param <CONSTANT>
 * @param <VARIABLE>
 * @param <PREDICATE>
 * @param <CONDITIONAL>
 */
public interface IVisitor<SORT,CONSTANT,VARIABLE,PREDICATE,CONDITIONAL> {
	Map<String, SORT> getSorts();
	Map<String, CONSTANT> getConstants();
	Map<String, VARIABLE> getVariables();
	Map<String, PREDICATE> getPredicates();
	Map<ConditionalContext, CONDITIONAL> getConditionals();
	Map<String, Collection<CONDITIONAL>> getKnowledgeBases();
	
	void visitTree(ParseTree tree);
}
