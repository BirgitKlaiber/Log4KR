package edu.cs.ai.log4KR.logical.semantics;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Conjunction;
import edu.cs.ai.log4KR.logical.syntax.Contradiction;
import edu.cs.ai.log4KR.logical.syntax.Disjunction;
import edu.cs.ai.log4KR.logical.syntax.ElementaryConjunction;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Implication;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.Literal;
import edu.cs.ai.log4KR.logical.syntax.Negation;
import edu.cs.ai.log4KR.logical.syntax.Tautology;




/**
 * A logical interpretation assigns a value to each interpretable object in its domain.
 * @author NicoPotyka
 *
 */
public abstract class Interpretation<I extends Interpretable> {
	
	
	public abstract boolean isTotallyDefinedFor(Formula<I> f);
	

	public abstract boolean satisfies(Atom<I> a);

	
	public boolean satisfies(Formula<I> f) {

		if(f instanceof Atom) {
			return satisfies((Atom<I>) f);
		}
		else if(f instanceof Literal) {
			return satisfies((Literal<I>) f);
		}
		else if(f instanceof ElementaryConjunction) {
			return satisfies((ElementaryConjunction<I>) f);
		}
		else if(f instanceof Negation) {
			return satisfies((Negation<I>) f);
		}
		else if(f instanceof Conjunction) {
			return satisfies((Conjunction<I>) f);
		}
		else if(f instanceof Disjunction) {
			return satisfies((Disjunction<I>) f);
		}
		else if(f instanceof Implication) {
			return satisfies((Implication<I>) f);
		}
		else if(f instanceof Tautology) {
			return true;
		}
		else if(f instanceof Contradiction) {
			return false;
		}
		
		throw new UnsupportedOperationException("Formulas of type "+f.getClass()+" are not supported yet.");
		
	}
	
	
	public boolean satisfies(Literal<I> l) {
		
		boolean satisfied = satisfies( l.getAtom());
		
		if(l.isPositive()) {
			return satisfied;
		}
		else {
			return !satisfied;
		}
		
	}
	
	
	public boolean satisfies(ElementaryConjunction<I> e) {

		//an elementary conjunction is satisfied if all contained literals are satisfied		
		for(Literal<I> l: e.getLiterals()) {
			
			if(!satisfies(l)) {
				return false;
			}
			
		}
		
		return true;
	}
	
	
	public boolean satisfies(Negation<I> n) {
		
		return !satisfies(n.getF());
		
	}
	
	
	public boolean satisfies(Conjunction<I> c) {
		
		return satisfies(c.getF1()) && satisfies(c.getF2());
		
	}

	
	public boolean satisfies(Disjunction<I> d) {
		
		return satisfies(d.getF1()) || satisfies(d.getF2());
		
	}

	
	public boolean satisfies(Implication<I> i) {
		
		return !satisfies(i.getF1()) || satisfies(i.getF2());
		
	}

}
