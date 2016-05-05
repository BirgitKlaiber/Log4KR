package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;
import java.util.HashSet;



/**
 * Represents a contradictory formula (singleton).
 * @author NicoPotyka
 *
 */
public class Contradiction<I extends Interpretable> implements Formula<I> {
	
	/*
	 * Warnings are suppressed, since Tautology objects just return constant values.  
	 */

	@SuppressWarnings("rawtypes")
	private static Contradiction contradiction;
	
	private Contradiction() {}

	@SuppressWarnings("rawtypes")
	public static Contradiction create() {
		if(contradiction == null) {
			contradiction = new Contradiction();
		}
		return contradiction;
	}
	
	@Override
	public String toString() {
		return "FALSE";
	}

	@Override
	public Collection<Atom<I>> getAtoms() {
		return new HashSet<Atom<I>>();
	}

	@Override
	public Formula<I> not() {
		@SuppressWarnings("unchecked")
		Formula<I> t = Tautology.create();
		return t;
	}

	@Override
	public Formula<I> and(Formula<I> f) {
		return f;
	}

	@Override
	public Formula<I> or(Formula<I> f) {
		return this;
	}

	@Override
	public Formula<I> implies(Formula<I> f) {
		return f;
	}
	
}
