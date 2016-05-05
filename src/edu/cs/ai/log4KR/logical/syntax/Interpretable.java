package edu.cs.ai.log4KR.logical.syntax;

/**
 * An atomic interpretable object like a propositional variable or a relational atom.
 * @author NicoPotyka
 *
 */
public interface Interpretable  {

	public String getName();
	public int getNoInterpretations();

}
