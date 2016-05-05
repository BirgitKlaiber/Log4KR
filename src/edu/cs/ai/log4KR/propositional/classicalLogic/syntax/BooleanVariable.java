package edu.cs.ai.log4KR.propositional.classicalLogic.syntax;

import java.util.Collection;
import java.util.HashSet;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Conjunction;
import edu.cs.ai.log4KR.logical.syntax.Disjunction;
import edu.cs.ai.log4KR.logical.syntax.ElementaryConjunction;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Implication;
import edu.cs.ai.log4KR.logical.syntax.Literal;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;


/**
 * A boolean propositional variable.
 * @see PropositionalVariable
 * @author NicoPotyka
 *
 */
public class BooleanVariable extends PropositionalVariable implements Atom<PropositionalVariable> {

	/**
     * Create binary propositional variable.
     * @param name
     */
	public BooleanVariable(String name) {
		super(name, null);
	}
	
	
	public boolean hasValue(String v) {
		//binary variables have no value
		return false;
	}
	
	public String getValue(int i) {
		//binary variables have no value
		return null;
	}
	
	@Override
	public int getNoInterpretations() {
		return 2;
	}

	@Override
	public String toString() {
		return name;
	}


	@Override
	public Formula<PropositionalVariable> not() {
		return new Literal<PropositionalVariable>(this,false);
	}


	@Override
	public Formula<PropositionalVariable> and(Formula<PropositionalVariable> f) {
		
		if(f instanceof Atom) {
			return new ElementaryConjunction<PropositionalVariable>(new Literal<PropositionalVariable>(this),new Literal<PropositionalVariable>((Atom<PropositionalVariable>) f));
		}
		else if(f instanceof Literal) {
			return new ElementaryConjunction<PropositionalVariable>(new Literal<PropositionalVariable>(this),(Literal<PropositionalVariable>) f);
		}
		return new Conjunction<PropositionalVariable>(this,f);
	}


	@Override
	public Formula<PropositionalVariable> or(Formula<PropositionalVariable> f) {
		return new Disjunction<PropositionalVariable>(this, f);
	}


	@Override
	public Formula<PropositionalVariable> implies(Formula<PropositionalVariable> f) {
		return new Implication<PropositionalVariable>(this, f);
	}


	@Override
	public Collection<Atom<PropositionalVariable>> getAtoms() {
		HashSet<Atom<PropositionalVariable>> atoms = new HashSet<Atom<PropositionalVariable>>();
		atoms.add(this);
		return atoms;
	}


	@Override
	public PropositionalVariable getInterpretable() {
		return this;
	}
}
