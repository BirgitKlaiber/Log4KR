package edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature;

/**
 * A term can be a constant or a variable. More generally it can be a function symbol over terms. Each term has a type and a name.
 * 
 * @author NicoPotyka
 *
 */
public interface Term {
	
	public Sort getType();
	public String getName();
	
	@Override
	public String toString();
	
	public boolean isGround();
	
	
}
