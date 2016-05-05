package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser;

import java.util.Collection;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public interface IVisitor <V, C> {
	Map<String, V> getVariables();

	Map<String, Collection<C>> getKnowledgeBases();

	void visitTree(ParseTree tree);
}
