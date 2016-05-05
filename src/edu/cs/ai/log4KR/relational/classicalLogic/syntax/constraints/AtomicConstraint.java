package edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Conjunction;
import edu.cs.ai.log4KR.logical.syntax.Disjunction;
import edu.cs.ai.log4KR.logical.syntax.ElementaryConjunction;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Implication;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.Literal;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Term;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;


/**
 * An atomic constraints states a relation (=, !=) between two terms.
 * @author NicoPotyka
 *
 */
public abstract class AtomicConstraint implements Atom<AtomicConstraint>, Interpretable {

	protected Term t1, t2;
	
	
	
	public AtomicConstraint(Term t1, Term t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	

	@Override
	public String getName() {
		return toString();
	}

	@Override
	public int getNoInterpretations() {
		return 2;
	}

	@Override
	public AtomicConstraint getInterpretable() {
		return this;
	}

	@Override
	public Formula<AtomicConstraint> and(Formula<AtomicConstraint> f) {
		if(f instanceof AtomicConstraint) {
			return new ElementaryConjunction<AtomicConstraint>(new Literal<AtomicConstraint>(this),new Literal<AtomicConstraint>((AtomicConstraint) f));
		}
		else if(f instanceof Literal) {
			return new ElementaryConjunction<AtomicConstraint>(new Literal<AtomicConstraint>(this),(Literal<AtomicConstraint>) f);
		}
		return new Conjunction<AtomicConstraint>(this,f);
	}

	@Override
	public Formula<AtomicConstraint> or(Formula<AtomicConstraint> f) {
		return new Disjunction<AtomicConstraint>(this, f);
	}

	@Override
	public Formula<AtomicConstraint> implies(Formula<AtomicConstraint> f) {
		return new Implication<AtomicConstraint>(this, f);
	}

	@Override
	public Collection<Atom<AtomicConstraint>> getAtoms() {
		return null;
	}


	public Term getT1() {
		return t1;
	}

	public Term getT2() {
		return t2;
	}


	
}
