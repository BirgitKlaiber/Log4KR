package edu.cs.ai.log4KR.logical.semantics;

import java.util.Collection;
import java.util.HashMap;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;


/**
 * The map representation of a possible world is a mapping of propositions to indices of their values.
 * For binary propositions, 0 represents FALSE and 1 represents TRUE.
 * @author NicoPotyka
 *
 */
public abstract class PossibleWorldMapRepresentation<I extends Interpretable> extends Interpretation<I> {

	protected HashMap<I, Integer> interpretation;
	protected Collection<I> interpretables;				//to store order for interpretables 
	
	
	
	protected PossibleWorldMapRepresentation(HashMap<I, Integer> interpretation) {
		this(interpretation,null);
	}
	
	protected PossibleWorldMapRepresentation(HashMap<I, Integer> interpretation, Collection<I> interpretables) {
		this.interpretation = interpretation;
		this.interpretables = interpretables;
	}

	protected PossibleWorldMapRepresentation(PossibleWorldMapRepresentation<I> world) {
		this.interpretation = new HashMap<I, Integer>(world.interpretation);
		this.interpretables = world.interpretables;
	}

	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(interpretation.keySet().size()*10+10);
		
		sb.append("(");
		
		Collection<I> vars;
		if(interpretables != null) {
			vars = interpretables;
		}
		else {
			vars = interpretation.keySet();
		}
		
		for(I p: vars) {
			sb.append(p);
			sb.append("=");
			sb.append(interpretation.get(p));
			sb.append(" ");
		}

		sb.append(")");
		return sb.toString();
	}

	public HashMap<I, Integer> getInterpretation() {
		return interpretation;
	}


	
	public boolean isTotallyDefinedFor(Formula<I> f) {
		
		boolean defined = true;
		for(Atom<I> atom: f.getAtoms()) {
			if(!interpretation.containsKey(atom.getInterpretable())) {
				defined = false;
				break;
			}
		}
		return defined;
		
	}
}
