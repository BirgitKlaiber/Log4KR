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

public class PropositionalAtom implements Atom<PropositionalVariable> {

	private PropositionalVariable var;
	private Integer valueIndex;  //for boolean propositional variables, valueIndex is null
	
	public PropositionalAtom(BooleanVariable var) {
		this.var = var;
		this.valueIndex = null;
	}
	
	public PropositionalAtom(PropositionalVariable var, String value) {

		this.var = var;
		
		if(var instanceof BooleanVariable) {
			this.valueIndex = null;
			return;
		}

		Integer index = var.getValueIndex(value);
		if(index == null) {
			throw new IllegalArgumentException("Multi-valued variable "+var+" cannot take value "+value+".");
		}
		this.valueIndex = index;
	}
	
	@Override
	public PropositionalVariable getInterpretable() {
		return var;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((valueIndex == null) ? 0 : valueIndex.hashCode());
		result = prime * result + ((var == null) ? 0 : var.hashCode());
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
		PropositionalAtom other = (PropositionalAtom) obj;
		if (valueIndex == null) {
			if (other.valueIndex != null)
				return false;
		} else if (!valueIndex.equals(other.valueIndex))
			return false;
		if (var == null) {
			if (other.var != null)
				return false;
		} else if (!var.equals(other.var))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		String s = var.getName();
		
		//boolean variables have no value index
		if(valueIndex==null) {
			return s;
		}

		return s+"="+var.getValue(valueIndex);
	}

	@Override
	public Collection<Atom<PropositionalVariable>> getAtoms() {
		HashSet<Atom<PropositionalVariable>> atoms = new HashSet<Atom<PropositionalVariable>>();
		atoms.add(this);
		return atoms;
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

	public Integer getValueIndex() {
		return valueIndex;
	}
	

}
