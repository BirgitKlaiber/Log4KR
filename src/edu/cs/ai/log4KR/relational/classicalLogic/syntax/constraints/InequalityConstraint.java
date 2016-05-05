package edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Term;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;


/**
 * Represents an unequality constraint (X!=t) for a variables X and a term t.
 * @author NicoPotyka
 *
 */
public class InequalityConstraint extends AtomicConstraint {
	
	public InequalityConstraint(Term t1, Term t2) {
		super(t1, t2);
	}


	@Override
	public String toString() {
		return t1.toString()+"!="+t2.toString();
	}


	/**
	 * Static import this method for more intuitive use in code.
	 * For instance call
	 * 
	 *   unequals(V,c);
	 *   
	 * instead of
	 * 
	 *   new InequalityConstraint(V,c)
	 *   
	 * @param var
	 * @param t
	 * @return
	 */
	public static InequalityConstraint unequals(Variable var, Term t) {
		return new InequalityConstraint(var, t);
	}


	@Override
	public Formula<AtomicConstraint> not() {
		return new EqualityConstraint(t1,t2);
	}


}
