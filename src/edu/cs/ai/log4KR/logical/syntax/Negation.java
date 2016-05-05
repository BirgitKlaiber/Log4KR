package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;

import edu.cs.ai.log4KR.GlobalVariables;


/**
 * Negation of a formula.
 * @author NicoPotyka
 *
 */
public class Negation<I extends Interpretable> implements Formula<I> {

	private Formula<I> f;
	
	public Negation(Formula<I> f) {
		this.f = f;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Negation other = (Negation) obj;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return GlobalVariables.NEGATION+"("+f.toString()+")";
	}

	@Override
	public Collection<Atom<I>> getAtoms() {
		return f.getAtoms();
	}

	public Formula<I> getF() {
		return f;
	}


	@Override
	public Formula<I> not() {
		return f;
	}

	public Formula<I> and(Formula<I> f) {
		return new Conjunction<I>(this, f);
	}

	public Formula<I> or(Formula<I> f) {
		return new Disjunction<I>(this, f);
	}

	public Formula<I> implies(Formula<I> f) {
		return new Implication<I>(this, f);
	}
	


}
