package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import edu.cs.ai.log4KR.GlobalVariables;



/**
 * An elementary conjunction is a conjunction of literals.
 * @author NicoPotyka
 *
 */
public class ElementaryConjunction<I extends Interpretable> implements Formula<I> {

	private Collection<Literal<I>> literals;
	
	public ElementaryConjunction(@SuppressWarnings("unchecked") Literal<I>... lits) {
		literals = new LinkedList<Literal<I>>();
		for(Literal<I> l: lits) {
			literals.add(l);
		}
	}
	
	public ElementaryConjunction(Collection<Literal<I>> literals) {
		this.literals = literals;
	}
	
	public ElementaryConjunction(ElementaryConjunction<I> e) {
		this(e.literals);
	}

	public Collection<Literal<I>> getLiterals() {
		return literals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((literals == null) ? 0 : literals.hashCode());
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
		ElementaryConjunction other = (ElementaryConjunction) obj;
		if (literals == null) {
			if (other.literals != null)
				return false;
		} else if (!literals.equals(other.literals))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		StringBuilder stringRep = new StringBuilder(10*literals.size());
		
		for(Literal<I> l: literals) {
			stringRep.append(l.toString()+" "+GlobalVariables.CONJUNCTION+" ");
		}
		//delete last conjunction
		if(stringRep.length()>0) stringRep.delete(stringRep.length()-3,stringRep.length());
		
		return stringRep.toString();
	}

	@Override
	public Collection<Atom<I>> getAtoms() {
		Collection<Atom<I>> atoms = new HashSet<Atom<I>>();
		for(Literal<I> l: literals) {
			atoms.addAll(l.getAtoms());
		}
		return atoms;
	}

	@Override
	public Formula<I> not() {
		return new Negation<I>(this);
	}

	@Override
	public Formula<I> and(Formula<I> f) {
		if(f instanceof Literal) {
			return and((Literal<I>) f);
		}
		else if(f instanceof ElementaryConjunction) {
			return and((ElementaryConjunction<I>) f);
		}
		return new Conjunction<I>(this,f);
	}
	
	public Formula<I> and(ElementaryConjunction<I> e) {
		ElementaryConjunction<I> newE = new ElementaryConjunction<I>(this);
		newE.literals.addAll(e.literals);
		return newE;
	}

	public Formula<I> and(Literal<I> l) {
		ElementaryConjunction<I> newE = new ElementaryConjunction<I>(this.literals);
		newE.literals.add(l);
		return newE;
	}
	
	@Override
	public Formula<I> or(Formula<I> f) {
		return new Disjunction<I>(this,f);
	}

	@Override
	public Formula<I> implies(Formula<I> f) {
		return new Implication<I>(this,f);
	}	
	
}
