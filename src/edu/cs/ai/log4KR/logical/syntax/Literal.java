package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;

import edu.cs.ai.log4KR.GlobalVariables;


/**
 * A literal is an atom (proposition) or its negation.
 * @author NicoPotyka
 *
 */
public class Literal<I extends Interpretable> implements Formula<I> {
	
	private Atom<I> atom;
	private boolean positive;     
	
	/**
	 * Create atom with boolean propositional variable.
	 * @param prop
	 * @param positive
	 */
	public Literal(Atom<I> atom) {
		this(atom,true);
	}
	
	/**
	 * Create literal with boolean propositional variable.
	 * @param prop
	 * @param positive
	 */
	public Literal(Atom<I> atom, boolean positive) {
		this.atom = atom;
		this.positive = positive;
	}
	
	/**
	 * Auxiliary constructor.
	 * @param l
	 */
	protected Literal(Literal<I> l) {
		atom = l.atom;
		positive = l.positive;
	}
	
	


	@Override
	public String toString() {

		if(!positive) {
			return GlobalVariables.NEGATION+atom.toString();
		}
		
		return atom.toString();
	}

	
	public Atom<I> getAtom() {
		return atom;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atom == null) ? 0 : atom.hashCode());
		result = prime * result + (positive ? 1231 : 1237);
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
		Literal other = (Literal) obj;
		if (atom == null) {
			if (other.atom != null)
				return false;
		} else if (!atom.equals(other.atom))
			return false;
		if (positive != other.positive)
			return false;
		return true;
	}

	@Override
	public Collection<Atom<I>> getAtoms() {
		return atom.getAtoms();
	}

	public boolean isPositive() {
		return positive;
	}

	
	@Override
	public Formula<I> not() {
		Literal<I> l = new Literal<I>(this);
		l.positive = !positive;
		return l;
	}
	
	@Override
	public Formula<I> and(Formula<I> f) {
		if(f instanceof Literal) {
			return and((Literal<I>) f);
		}
		else if(f instanceof ElementaryConjunction) {
			return and((ElementaryConjunction<I>) f);
		}
		return new Conjunction<I>(this, f);
	}
	
	public Formula<I> and(ElementaryConjunction<I> e) {
		@SuppressWarnings("unchecked")
		ElementaryConjunction<I> newE = new ElementaryConjunction<I>(this);
		newE.getLiterals().addAll(e.getLiterals());
		return newE;
	}

	public Formula<I> and(Literal<I> l) {
		@SuppressWarnings("unchecked")
		ElementaryConjunction<I> newE = new ElementaryConjunction<I>(this,l);
		return newE;
	}
	@Override
	public Formula<I> or(Formula<I> f) {
		return new Disjunction<I>(this, f);
	}

	@Override
	public Formula<I> implies(Formula<I> f) {
		return new Implication<I>(this, f);
	}
	
	
}
