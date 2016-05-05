package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public interface IReader <V, C>{
	void read(String path);
	void read(File file);
	void read(InputStream in);
	
	Collection<V> getVariables();
	V getVariable(String name);
	Collection<C> getKnowledgeBase(String name);
	Map<String, Collection<C>> getKnowledgeBases();
}
