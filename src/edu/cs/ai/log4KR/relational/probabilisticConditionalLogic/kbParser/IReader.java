package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
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
public interface IReader <SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL>{

	void read(String path);
	void read(File file);
	void read(InputStream in);
	void readFromString(String s);
	
	Collection<SORT> getSorts();
	Collection<CONSTANT> getConstants();
	Collection<VARIABLE> getVariables();
	Collection<PREDICATE> getPredicates();
	Collection<CONDITIONAL> getConditionals();
	Map<String, Collection<CONDITIONAL>> getKnowledgeBases();
	
	SORT getSort(String sortName);
	CONSTANT getConstant(String consName);
	VARIABLE getVariable(String varName);
	PREDICATE getPredicate(String predName);
	Collection<CONDITIONAL> getKnowledgeBase(String knowledgeBase);
}
