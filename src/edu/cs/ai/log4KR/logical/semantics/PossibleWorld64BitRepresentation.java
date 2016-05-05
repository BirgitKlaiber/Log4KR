package edu.cs.ai.log4KR.logical.semantics;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;

/**
 * Possible world represented as a 64bit sequence (long).
 * (naturally, number of possible worlds is restricted by max value of long)
 * 
 * @author NicoPotyka
 *
 */
public abstract class PossibleWorld64BitRepresentation<I extends Interpretable> extends Interpretation<I> {

	/**
	 * Stores information about atoms that are interpreted by possible worlds.
	 * @author NicoPotyka
	 *
	 */
	public static class AtomInformation<I extends Interpretable> {
		
		int noAtoms;
		
		long[] stride; //(step size)
		int[] cardinality; 
		
		Map<I, Integer> mapInterpretableToInt;
		
		Collection<I> interpretables;				//to store order for interpretables 
	
	
		public AtomInformation(Collection<I> atoms) {
			this.noAtoms = atoms.size();
			stride = new long[noAtoms];
			cardinality = new int[noAtoms];
			
			mapInterpretableToInt = new HashMap<I, Integer>();
			
			interpretables = atoms;
			
			int i=0;
			int curStride = 1;
			for(I atom: atoms) {
				
				stride[i] = curStride;
				cardinality[i] = atom.getNoInterpretations();
				mapInterpretableToInt.put(atom, i);
				
				curStride *= cardinality[i];			
				i++;
			}
			
		}
	
	}
	
	
	protected AtomInformation<I> atomInfo;
	protected Set<I> definedInterpretables;
	protected long interpretation;
	
	public PossibleWorld64BitRepresentation(AtomInformation<I> atomInfo) {
		this(atomInfo,0,null);
	}
	
	public PossibleWorld64BitRepresentation(AtomInformation<I> atomInfo, long interpretation, Set<I> definedInterpretables) {
		this.atomInfo = atomInfo;
		this.interpretation = interpretation;
		if(definedInterpretables==null) {
			definedInterpretables = new HashSet<I>();
		}
		this.definedInterpretables = definedInterpretables;
	}
	
	public PossibleWorld64BitRepresentation(PossibleWorld64BitRepresentation<I> other) {
		this(other.atomInfo, other.interpretation, new HashSet<I>(other.definedInterpretables));
	}
	
	
	
	
	protected int getValue(I interpretable) {
		//undefined atoms are supposed to be false 
		if(!definedInterpretables.contains(interpretable))  return -1;
		
		return getValue(atomInfo.mapInterpretableToInt.get(interpretable));
	}
	
	protected int getValue(int index) {
		return (int) ( (interpretation / atomInfo.stride[index]) % atomInfo.cardinality[index]);
	}
	
	/**
	 * Set value of interpretable object. Call it only once, when
	 * initializing, otherwise errors will occur.
	 * 
	 * @param interpretable
	 * @return
	 */
	public void setValue(I interpretable, int value) {
		
		if(definedInterpretables.contains(interpretable)) {
			throw new RuntimeException("Interpretation of "+interpretable+" is already set and cannot be changed.");
		}
		setValue(atomInfo.mapInterpretableToInt.get(interpretable),value);
		definedInterpretables.add(interpretable);
	}
	/**
	 * Set value of interpretable object. Call it only once, when
	 * initializing, otherwise errors will occur.
	 * 
	 * @param interpretable
	 * @return
	 */
	protected void setValue(int i, int value) {
		interpretation += atomInfo.stride[i]*value;
	}
	
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(atomInfo.noAtoms*10+10);
		
		sb.append("(");
		
		Collection<I> vars;
		if(atomInfo.interpretables != null) {
			vars = atomInfo.interpretables;
		}
		else {
			vars = atomInfo.mapInterpretableToInt.keySet();
		}
		
		for(I p: vars) {
			sb.append(p);
			sb.append("=");
			if(atomInfo.mapInterpretableToInt.containsKey(p))  {
				sb.append(getValue(p));
			}
			else {
				sb.append("_|_");
			}
			sb.append(" ");
		}

		sb.append(")");
		return sb.toString();
	}

	
	public boolean isTotallyDefinedFor(Formula<I> f) {
		
		boolean defined = true;
		for(Atom<I> atom: f.getAtoms()) {
			if(!definedInterpretables.contains(atom.getInterpretable())) {
				defined = false;
				break;
			}
		}
		return defined;
		
	}
}
