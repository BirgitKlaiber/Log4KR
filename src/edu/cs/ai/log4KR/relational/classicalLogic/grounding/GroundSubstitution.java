package edu.cs.ai.log4KR.relational.classicalLogic.grounding;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Conjunction;
import edu.cs.ai.log4KR.logical.syntax.Disjunction;
import edu.cs.ai.log4KR.logical.syntax.ElementaryConjunction;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Implication;
import edu.cs.ai.log4KR.logical.syntax.Literal;
import edu.cs.ai.log4KR.logical.syntax.Negation;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.EqualityConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.InequalityConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Term;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalFact;

/**
 * A ground substitution maps variables to constants
 * and interprets constraints formulas.
 * 
 * @author NicoPotyka
 *
 */
public class GroundSubstitution extends Interpretation<AtomicConstraint> {

	protected HashMap<Variable, Constant> mapVarToConst;
	
	public GroundSubstitution() {
		mapVarToConst = new HashMap<Variable, Constant>();
	}

	public GroundSubstitution(GroundSubstitution g) {
		this.mapVarToConst = new HashMap<Variable, Constant>(g.mapVarToConst);
	}
	
	
	

	
	/*
	 * 
	 * Map terms and formulas.
	 * 
	 * 
	 */
	
	public Constant map(Term t) {
		if(t instanceof Variable) {
			return mapVarToConst.get(t);
		}
		else if(t instanceof Constant) {
			return (Constant) t;
		}
		else {
			//currently there are only constants and variables
			throw new UnsupportedOperationException("Currently terms can be only variables and constants.");
		}
		
	}
	
	
	public RelationalAtom map(RelationalAtom atom) {
		
		if(atom.isGround()) {
			return atom;
		}
		
		Predicate predicate = atom.getPredicate();
		Term[] arguments = atom.getArguments();
		Term[] groundArguments = new Term[arguments.length];
		for(int i=0; i<arguments.length; i++) {
			groundArguments[i] = map(arguments[i]);
		}
		
		return new RelationalAtom(predicate, groundArguments);
		
	}
	
	
	
	public Literal<RelationalAtom> map(Literal<RelationalAtom> l) {
		
		return new Literal<RelationalAtom>(map((RelationalAtom) l.getAtom()), l.isPositive());
		
	}
	
	
	public ElementaryConjunction<RelationalAtom> map(ElementaryConjunction<RelationalAtom> con) {
		
		Collection<Literal<RelationalAtom>> literals = con.getLiterals();
		Collection<Literal<RelationalAtom>> groundLiterals = new LinkedList<Literal<RelationalAtom>>();
		for(Literal<RelationalAtom> literal: literals) {
			groundLiterals.add(map(literal));
		}
		
		return new ElementaryConjunction<RelationalAtom>(groundLiterals);
		
	}
	
	
	public Negation<RelationalAtom> map(Negation<RelationalAtom> neg) {
		return new Negation<RelationalAtom>(map(neg.getF()));
	}
	
	
	public Conjunction<RelationalAtom> map(Conjunction<RelationalAtom> con) {
		
		return new Conjunction<RelationalAtom>(map(con.getF1()),map(con.getF2()));
		
	}
	
	
	public Disjunction<RelationalAtom> map(Disjunction<RelationalAtom> dis) {
		
		return new Disjunction<RelationalAtom>(map(dis.getF1()),map(dis.getF2()));
		
	}
	
	
	public Implication<RelationalAtom> map(Implication<RelationalAtom> imp) {
		
		return new Implication<RelationalAtom>(map(imp.getF1()),map(imp.getF2()));
		
	}
	
	
	public Formula<RelationalAtom> map(Formula<RelationalAtom> f) {
		
		if(f instanceof RelationalAtom) {
			return map((RelationalAtom) f);
		}
		else if(f instanceof Literal) {
			return map((Literal<RelationalAtom>) f);
		}
		else if(f instanceof ElementaryConjunction) {
			return map((ElementaryConjunction<RelationalAtom>) f);
		}
		else if(f instanceof Negation) {
			return map((Negation<RelationalAtom>) f);
		}
		else if(f instanceof Conjunction) {
			return map((Conjunction<RelationalAtom>) f);
		}
		else if(f instanceof Disjunction) {
			return map((Disjunction<RelationalAtom>) f);
		}
		else if(f instanceof Implication) {
			return map((Implication<RelationalAtom>) f);
		}
		
		throw new UnsupportedOperationException("Formulas of type "+f.getClass()+" are not supported yet.");
		
	}
	
	
	
	

	public EqualityConstraint mapConstraint(EqualityConstraint ec) {
		
		return new EqualityConstraint(map(ec.getT1()), map(ec.getT2()));
		
	}

	public InequalityConstraint mapConstraint(InequalityConstraint ic) {
		
		return new InequalityConstraint(map(ic.getT1()), map(ic.getT2()));
		
	}
	
	public AtomicConstraint mapConstraint(AtomicConstraint atom) {
		
		if(atom instanceof EqualityConstraint) {
			return mapConstraint((EqualityConstraint) atom);
		}
		
		if(atom instanceof InequalityConstraint) {
			return mapConstraint((InequalityConstraint) atom);
		}
		
		throw new UnsupportedOperationException("Atomic constraints of type "+atom.getClass()+" are not supported yet.");
		
	}
		
	public Literal<AtomicConstraint> mapConstraint(Literal<AtomicConstraint> l) {
		
		return new Literal<AtomicConstraint>((AtomicConstraint) l.getAtom(), l.isPositive());
		
	}
	
	
	public ElementaryConjunction<AtomicConstraint> mapConstraint(ElementaryConjunction<AtomicConstraint> con) {
		
		Collection<Literal<AtomicConstraint>> literals = con.getLiterals();
		Collection<Literal<AtomicConstraint>> groundLiterals = new LinkedList<Literal<AtomicConstraint>>();
		for(Literal<AtomicConstraint> literal: literals) {
			groundLiterals.add(mapConstraint(literal));
		}
		
		return new ElementaryConjunction<AtomicConstraint>(groundLiterals);
		
	}
	
	
	public Negation<AtomicConstraint> mapConstraint(Negation<AtomicConstraint> neg) {
		return new Negation<AtomicConstraint>(mapConstraint(neg.getF()));
	}
	
	
	public Conjunction<AtomicConstraint> mapConstraint(Conjunction<AtomicConstraint> con) {
		
		return new Conjunction<AtomicConstraint>(mapConstraint(con.getF1()),mapConstraint(con.getF2()));
		
	}
	
	
	public Disjunction<AtomicConstraint> mapConstraint(Disjunction<AtomicConstraint> dis) {
		
		return new Disjunction<AtomicConstraint>(mapConstraint(dis.getF1()),mapConstraint(dis.getF2()));
		
	}
	
	
	public Implication<AtomicConstraint> mapConstraint(Implication<AtomicConstraint> imp) {
		
		return new Implication<AtomicConstraint>(mapConstraint(imp.getF1()),mapConstraint(imp.getF2()));
		
	}
	
	
	
	public Formula<AtomicConstraint> mapConstraint(Formula<AtomicConstraint> c) {
		
		if(c instanceof AtomicConstraint) {
			return mapConstraint((AtomicConstraint) c);
		}
		if(c instanceof EqualityConstraint) {
			return mapConstraint((EqualityConstraint) c);
		}
		if(c instanceof InequalityConstraint) {
			return mapConstraint((InequalityConstraint) c);
		}
		else if(c instanceof Literal) {
			return mapConstraint((Literal<AtomicConstraint>) c);
		}
		else if(c instanceof ElementaryConjunction) {
			return mapConstraint((ElementaryConjunction<AtomicConstraint>) c);
		}
		else if(c instanceof Negation) {
			return mapConstraint((Negation<AtomicConstraint>) c);
		}
		else if(c instanceof Conjunction) {
			return mapConstraint((Conjunction<AtomicConstraint>) c);
		}
		else if(c instanceof Disjunction) {
			return mapConstraint((Disjunction<AtomicConstraint>) c);
		}
		else if(c instanceof Implication) {
			return mapConstraint((Implication<AtomicConstraint>) c);
		}
		
		throw new UnsupportedOperationException("Constraint formulas of type "+c.getClass()+" are not supported yet.");
		
	}
	
	
	public RelationalFact map(RelationalFact f) {
		
		return new RelationalFact(map(f.getConsequence()),f.getProbability(),
				f.getConstraint()==null?null:mapConstraint(f.getConstraint()));
		
	}
	
	
	public RelationalConditional map(RelationalConditional cond) {
		
		if(cond instanceof RelationalFact) {
			return map((RelationalFact) cond);
		}
		
		return new RelationalConditional(map(cond.getConsequence()),map(cond.getAntecedence()),cond.getProbability(),
				cond.getConstraint()==null?null:mapConstraint(cond.getConstraint()));
	}
	
	
	


	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mapVarToConst == null) ? 0 : mapVarToConst.hashCode());
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
		GroundSubstitution other = (GroundSubstitution) obj;
		if (mapVarToConst == null) {
			if (other.mapVarToConst != null)
				return false;
		} else if (!mapVarToConst.equals(other.mapVarToConst))
			return false;
		return true;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(Variable v: mapVarToConst.keySet()) {
			sb.append(v+"/"+mapVarToConst.get(v)+ " ");
		}
		sb.append(")");
		
		return sb.toString();
	}

	
	
	@Override
	public boolean satisfies(Atom<AtomicConstraint> a) {
		
		if(a instanceof EqualityConstraint) {
			return 	map(((EqualityConstraint) a).getT1()).
					equals
					(map(((EqualityConstraint) a).getT2())); 
		}
		else if(a instanceof InequalityConstraint) {
			return 	!map(((InequalityConstraint) a).getT1()).
					equals
					(map(((InequalityConstraint) a).getT2())); 
		}
		
		throw new UnsupportedOperationException("Atomic constraints of type "+a.getClass()+" are not supported yet.");
		
	}

	
	public boolean isTotallyDefinedFor(Formula<AtomicConstraint> f) {
		
		boolean defined = true;
		for(Atom<AtomicConstraint> atom: f.getAtoms()) {
			if(!mapVarToConst.containsKey(atom.getInterpretable())) {
				defined = false;
				break;
			}
		}
		return defined;
		
	}
	
}
