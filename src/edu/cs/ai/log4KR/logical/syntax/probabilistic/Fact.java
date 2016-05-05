package edu.cs.ai.log4KR.logical.syntax.probabilistic;

import java.util.Collection;
import java.util.HashSet;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.Tautology;
import edu.cs.ai.log4KR.math.types.Fraction;


/**
 * A Fact is a Conditional with tautological antecedence.
 * @see Conditional
 * @author koecher, NicoPotyka
 *
 */
public class Fact<I extends Interpretable> extends Conditional<I> {
	
	
	public Fact(Formula<I> consequence, Fraction probability) {
		super(consequence,Tautology.create(),probability);
	}
	
	public Fact(Formula<I> consequence, double probability) {
		super(consequence,Tautology.create(),new Fraction(probability));
	}
	
	public Fact(Formula<I> consequence, String probability) {
		super(consequence,Tautology.create(),new Fraction(probability));
	}
	
	public Fact(Formula<I> consequence) {
		super(consequence,Tautology.create());
	}
	
	@Override
	protected String getConditionalString() {
		return ("(" + consequence + ")");
	}
	
	@Override
	public Collection<Atom<I>> getAtoms() {
		HashSet<Atom<I>> atoms = new HashSet<Atom<I>>();
		atoms.addAll(consequence.getAtoms());
		return atoms;
	}
}
