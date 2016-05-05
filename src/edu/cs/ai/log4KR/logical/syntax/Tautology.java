package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;
import java.util.HashSet;



/**
 * Represents a tautological formula (singleton).
 * @author NicoPotyka
 *
 */
public class Tautology<I extends Interpretable> implements Formula<I> {
	
	/*
	 * Warnings are suppressed, since Tautology objects just return constant values.  
	 */

	@SuppressWarnings("rawtypes")
	private static Tautology tautology;
	
	private Tautology() {}

	@SuppressWarnings("rawtypes")
	public static Tautology create() {
		if(tautology == null) {
			tautology = new Tautology();
		}
		return tautology;
	}
	
	@Override
	public String toString() {
		return "TRUE";
	}

	@Override
	public Collection<Atom<I>> getAtoms() {
		return new HashSet<Atom<I>>();
	}

	@Override
	public Formula<I> not() {
		@SuppressWarnings("unchecked")
		Formula<I> c = Contradiction.create();
		return c;
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
