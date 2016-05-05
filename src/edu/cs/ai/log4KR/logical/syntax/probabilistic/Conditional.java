package edu.cs.ai.log4KR.logical.syntax.probabilistic;

import java.util.Collection;
import java.util.HashSet;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.math.types.Fraction;



/**
 * This class represents a Conditional.
 * 
 * @author koecher, NicoPotyka
 *
 */

public class Conditional<I extends Interpretable> {
	
	protected Formula<I> antecedence;
	protected Formula<I> consequence;
	protected Fraction probability;
	
	
	
	public static final int DISPLAY_PROBABILITY = 0;
	public static final int DISPLAY_IF_PROBABILITY_IS_SET = 1;
	public static final int DEBUG = -1;
	private static int displayType = DISPLAY_IF_PROBABILITY_IS_SET;
	
	public Conditional(Formula<I> consequence, Formula<I> antecedence, Fraction probability) {
		this.antecedence = antecedence;
		this.consequence = consequence;
		this.probability = probability;
	}
	
	public Conditional(Formula<I> consequence, Formula<I> antecedence, double probability) {
		this(consequence,antecedence,new Fraction(probability));
	}

	public Conditional(Formula<I> consequence, Formula<I> antecedence) {
		this(consequence,antecedence,null);
	}
	
	@Override
	public String toString() {
		switch(displayType){
			case DISPLAY_PROBABILITY: return getConditionalString()+"[" + probability + "]";
			case DISPLAY_IF_PROBABILITY_IS_SET: return getConditionalString() + (probability==null?"":"[" + probability + "]");
			default: return getConditionalString()+"[" + probability + "]";
		}
	}
	
	protected String getConditionalString(){
		return ("(" + consequence + "|" + antecedence + ")");
	}
	
	public Formula<I> getAntecedence() {
		return antecedence;
	}

	public Formula<I> getConsequence() {
		return consequence;
	}

	public Fraction getProbability() {
		return probability;
	}

	public void setProbability(Fraction probability) {
		this.probability = probability;
	}

	public static int getDisplayType() {
		return displayType;
	}
	
	
	/**
	 * Sets the display type of a Conditional.
	 * 
	 * @param _displayType
	 * <p>
	 * <li>{@link #DISPLAY_PROBABILITY} - Shows probability, even if it is <code>null</code>.</li>
	 * <li>{@link #DISPLAY_IF_PROBABILITY_IS_SET} - Shows probability only if it is set.</li>
	 */
	public static void setDisplayType(int _displayType) {
		displayType = _displayType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antecedence == null) ? 0 : antecedence.hashCode());
		result = prime * result
				+ ((consequence == null) ? 0 : consequence.hashCode());
		result = prime * result
				+ ((probability == null) ? 0 : probability.hashCode());
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
		Conditional other = (Conditional) obj;
		if (antecedence == null) {
			if (other.antecedence != null)
				return false;
		} else if (!antecedence.equals(other.antecedence))
			return false;
		if (consequence == null) {
			if (other.consequence != null)
				return false;
		} else if (!consequence.equals(other.consequence))
			return false;
		if (probability == null) {
			if (other.probability != null)
				return false;
		} else if (!probability.equals(other.probability))
			return false;
		return true;
	}
	
	
	public Collection<Atom<I>> getAtoms() {
		HashSet<Atom<I>> atoms = new HashSet<Atom<I>>();
		atoms.addAll(antecedence.getAtoms());
		atoms.addAll(consequence.getAtoms());
		return atoms;
	}
}