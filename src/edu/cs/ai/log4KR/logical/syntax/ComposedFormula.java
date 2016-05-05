package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;
import java.util.HashSet;

/**
 * A composed formula consists of two formulas (e.g. conjunction, disjunction, implication).
 * 
 * @author NicoPotyka
 *
 */
public abstract class ComposedFormula<I extends Interpretable> implements Formula<I> {

	protected Formula<I> f1, f2;
	
	
	
	public ComposedFormula(Formula<I> f1, Formula<I> f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f1 == null) ? 0 : f1.hashCode());
		result = prime * result + ((f2 == null) ? 0 : f2.hashCode());
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
		ComposedFormula other = (ComposedFormula) obj;
		if (f1 == null) {
			if (other.f1 != null)
				return false;
		} else if (!f1.equals(other.f1))
			return false;
		if (f2 == null) {
			if (other.f2 != null)
				return false;
		} else if (!f2.equals(other.f2))
			return false;
		return true;
	}	
	
	
	@Override
	public Collection<Atom<I>> getAtoms() {
		Collection<Atom<I>> atoms = new HashSet<Atom<I>>();
		atoms.addAll(f1.getAtoms());
		atoms.addAll(f2.getAtoms());
		return atoms;
	}



	public Formula<I> not() {
		return new Negation<I>(this);
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




	public Formula<I> getF1() {
		return f1;
	}

	public Formula<I> getF2() {
		return f2;
	}
	
}
