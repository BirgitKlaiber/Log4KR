package edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Term;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;

/**
 * Represents an equality constraint (X=t) for a variable X and a term t.
 * 
 * @author NicoPotyka
 *
 */
public class EqualityConstraint extends AtomicConstraint {

	public EqualityConstraint(Term t1, Term t2) {
		super(t1, t2);
	}

	@Override
	public String toString() {
		return t1.toString() + "=" + t2.toString();
	}

	/**
	 * Static import this method for more intuitive use in code. For instance
	 * call
	 * 
	 * equals(V,c);
	 * 
	 * instead of
	 * 
	 * new EqualityConstraint(V,c)
	 * 
	 * @param var
	 * @param t
	 * @return
	 */
	public static EqualityConstraint equals(Variable var, Term t) {
		return new EqualityConstraint(var, t);
	}

	@Override
	public boolean equals(Object obj) {
		EqualityConstraint right = (EqualityConstraint) obj;
		if (getT1().equals(right.getT1()) && getT2().equals(right.getT2())) {
			return true;
		}
		return false;
	}

	@Override
	public Formula<AtomicConstraint> not() {
		return new InequalityConstraint(t1, t2);
	}

}
