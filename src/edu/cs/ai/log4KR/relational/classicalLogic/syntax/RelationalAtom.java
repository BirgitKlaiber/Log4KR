package edu.cs.ai.log4KR.relational.classicalLogic.syntax;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Conjunction;
import edu.cs.ai.log4KR.logical.syntax.Disjunction;
import edu.cs.ai.log4KR.logical.syntax.ElementaryConjunction;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Implication;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.Literal;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundSubstitution;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.*;



/**
 * A relational atom has the form A(t1,...,tn), where ti are terms. A is called the name of the atom. If n=0 A is called a proposition.  
 * @author NicoPotyka
 *
 */
public class RelationalAtom implements Interpretable, Atom<RelationalAtom> {

	private Predicate predicate;
	private Term[] arguments;
	
	
	
	public RelationalAtom(Predicate predicate, Term... arguments) {
		
		if(arguments.length != predicate.getArity()) {
			throw new IllegalArgumentException("Number of arguments does not match arity of predicate "+predicate.toString());
		}
		
		if(!predicate.validArguments(arguments)) {
			throw new IllegalArgumentException("Illegal arguments for predicate "+predicate.toString());
		}
		
		this.predicate = predicate;
		this.arguments = arguments;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder stringRep = new StringBuilder(predicate.getName().length()+7*arguments.length);
		
		stringRep.append(predicate.getName());
		
		//if predicate has arguments print them.
		if(arguments.length>0) {
			stringRep.append("(");
			for(Term t: arguments) {
				stringRep.append(t.toString()+",");
			}
			//delete last comma
			stringRep.deleteCharAt(stringRep.length()-1);
			stringRep.append(")");
		}
		
		return stringRep.toString();
	}
	

	public boolean isGround() {
		
		for(int i=0; i<arguments.length; i++) {
			if(!arguments[i].isGround()) {
				return false;
			}
		}
		
		return true;
	}


	public Collection<Variable> getVariables() {
		
		Set<Variable> variables = new HashSet<Variable>();
		
		for(int i=0; i<arguments.length; i++) {
			if(!arguments[i].isGround()) {
				variables.add((Variable) arguments[i]);
			}
		}
		
		return variables;
	}

	public Collection<Constant> getConstants() {
		
		Set<Constant> constants = new HashSet<Constant>();
		
		for(int i=0; i<arguments.length; i++) {
			if(arguments[i].isGround()) {
				constants.add((Constant) arguments[i]);
			}
		}
		
		return constants;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arguments);
		result = prime * result
				+ ((predicate == null) ? 0 : predicate.hashCode());
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
		RelationalAtom other = (RelationalAtom) obj;
		if (!Arrays.equals(arguments, other.arguments))
			return false;
		if (predicate == null) {
			if (other.predicate != null)
				return false;
		} else if (!predicate.equals(other.predicate))
			return false;
		return true;
	}



	public Formula<RelationalAtom> getGroundFormula(GroundSubstitution g) {

		Term[] groundArguments = new Term[arguments.length];
		for(int i=0; i<arguments.length; i++) {
			groundArguments[i] = g.map(arguments[i]);
		}
		return new RelationalAtom(predicate, groundArguments);
	}



	@Override
	public String getName() {
		return predicate.getName();
	}



	@Override
	public int getNoInterpretations() {
		//relational atom can be true or false
		return 2;
	}



	@Override
	public RelationalAtom getInterpretable() {
		return this;
	}



	@Override
	public Collection<Atom<RelationalAtom>> getAtoms() {
		HashSet<Atom<RelationalAtom>> atoms = new HashSet<Atom<RelationalAtom>>();
		atoms.add(this);
		return atoms;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public Term[] getArguments() {
		return arguments;
	}



	@Override
	public Formula<RelationalAtom> not() {
		return new Literal<RelationalAtom>(this,false);
	}

	@Override
	public Formula<RelationalAtom> and(Formula<RelationalAtom> f) {
		
		if(f instanceof Atom) {
			return new ElementaryConjunction<RelationalAtom>(new Literal<RelationalAtom>(this),new Literal<RelationalAtom>((Atom<RelationalAtom>) f));
		}
		else if(f instanceof Literal) {
			return new ElementaryConjunction<RelationalAtom>(new Literal<RelationalAtom>(this),(Literal<RelationalAtom>) f);
		}
		return new Conjunction<RelationalAtom>(this,f);
	}

	@Override
	public Formula<RelationalAtom> or(Formula<RelationalAtom> f) {
		return new Disjunction<RelationalAtom>(this, f);
	}

	@Override
	public Formula<RelationalAtom> implies(Formula<RelationalAtom> f) {
		return new Implication<RelationalAtom>(this, f);
	}
	
	
}
