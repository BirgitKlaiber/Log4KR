package edu.cs.ai.log4KR.logical.syntax;

import java.util.Collection;

import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.BooleanVariable;



/**
 * Abstract superclass for formulas. To generate formulas, create Atoms first. 
 * Then use methods not, and, or, implies to create complex formulas. 
 * more complex formulas.
 * @see BooleanVariable
 * @see Literal
 * @see ElementaryConjunction
 * @see Negation
 * @see Conjunction
 * @see Disjunction
 * @see Implication
 * 
 * @author NicoPotyka
 *
 */
public interface Formula<I extends Interpretable> {

	public Formula<I> not();

	public Formula<I> and(Formula<I> f);

	public Formula<I> or(Formula<I> f);

	public Formula<I> implies(Formula<I> f);
	
	public Collection<Atom<I>> getAtoms();

}
