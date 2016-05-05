package edu.cs.ai.log4KR.logical.semantics;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;


/**
 * Should be used to generate possible worlds.
 * @author NicoPotyka
 *
 * @param <I>
 */
public abstract class PossibleWorldFactory<I extends Interpretable> {
	
	

	class AtomContainer implements Comparable<AtomContainer> {
	
		
		private double priority;
		private I atom;
		private Collection<Conditional<I>> zeroConds, oneConds;
		
		public AtomContainer(I atom) {
			this(atom,0);
		}
		public AtomContainer(I atom, double priority) {
			this.atom = atom;
			this.priority = priority;
			zeroConds = new LinkedList<Conditional<I>>();
			oneConds = new LinkedList<Conditional<I>>();
		}
	
		@Override
		public int compareTo(AtomContainer o) {
			double d = this.priority - o.priority;
			if(d<0) return -1;
			else if(d>0) return 1;
			else return 0;
		}
		
		public void addOneConditional(Conditional<I> c) {
			oneConds.add(c);
		}
		
		public void addZeroConditional(Conditional<I> c) {
			zeroConds.add(c);
		}
		
		/**
		 * Set priority if given value is greater than current priority.
		 * @param priority
		 */
		public void setPriorityToMin(double p) {
			if(p<priority) {
				priority = p;
			}
		}
		
		
		
		public double getPriority() {
			return priority;
		}
		public void setPriority(double priority) {
			this.priority = priority;
		}
	
		public I getAtom() {
			return atom;
		}
		
		public Collection<Conditional<I>> getZeroConds() {
			return zeroConds;
		}
		
		public Collection<Conditional<I>> getOneConds() {
			return oneConds;
		}

	
		@Override
		public String toString() {
			return atom.toString()+": "+priority;
		}
		
	}

	
	
	
	
	
	/**
	 * Create all possible worlds over a set of interpretable atoms
	 * that do not violate the given deterministic ground conditionals.
	 * Note that all conditionals are supposed to be ground.
	 * @param atoms
	 * @param detConds deterministic ground conditionals
	 * @return
	 */
	public Interpretation<I>[] createPossibleWorldsWithoutNullworlds(Collection<I> atoms, Collection<Conditional<I>> detConds) {

		//create an atom container for each atom and determine violated deterministic conditionals and priorities of atoms
		int noAtoms = atoms.size();
		ArrayList<PossibleWorldFactory<I>.AtomContainer> richAtoms = new ArrayList<PossibleWorldFactory<I>.AtomContainer>(noAtoms);
		for(I atom: atoms) {
			richAtoms.add(new AtomContainer(atom));
		}
		for(Conditional<I> c: detConds) {
			
			double prob = c.getProbability().toFloatingPoint(); 
			if(prob!=1 && prob!= 0) {
				throw new RuntimeException("Probability of "+c+" is neither one nor zero (maybe for numerical reasons).");
			}
			Collection<Atom<I>> cAtoms = c.getAtoms();
			double prio = - 1d/cAtoms.size();
			
			for(Atom<I> at: c.getAtoms()) {

				for(int i=0; i<noAtoms; i++) {
					if(richAtoms.get(i).getAtom().equals(at)) {
						if(prob==0) {
							richAtoms.get(i).addZeroConditional(c);
						}
						else {
							richAtoms.get(i).addOneConditional(c);
						}
						richAtoms.get(i).setPriorityToMin(prio);
						break;
					}
				}
				
			}
		}

		Collections.sort(richAtoms);
		
		
		//generate worlds excluding violating worlds
		LinkedList<Interpretation<I>> worlds = new LinkedList<Interpretation<I>>();
		
		//add empty interpretation
		worlds.add(createEmptyWorld(atoms));
		
		for(AtomContainer atC: richAtoms) {
			I atom = atC.getAtom();
			LinkedList<Interpretation<I>> newWorlds = new LinkedList<Interpretation<I>>();
			
			for(Interpretation<I> partialWorld: worlds) {
				
				//extend partial world to a new world for each possible interpretation of prop
				//add new world only if it does not violate any deterministic conditionals
				for(int i=0; i<atom.getNoInterpretations(); i++) {
					
					Interpretation<I> candidate = extendWorld(partialWorld,atom,i);
					boolean violates = false;
					for(Conditional<I> c: atC.getZeroConds()) {
						if(candidate.isTotallyDefinedFor(c.getAntecedence()) && candidate.satisfies(c.getAntecedence()) 
								&& candidate.isTotallyDefinedFor(c.getConsequence()) && candidate.satisfies(c.getConsequence())) {
							violates = true;
							break;
						}
					}
					
					if(!violates) {
						for(Conditional<I> c: atC.getOneConds()) {
							if(candidate.isTotallyDefinedFor(c.getAntecedence()) && candidate.satisfies(c.getAntecedence()) 
									&& candidate.isTotallyDefinedFor(c.getConsequence()) && !candidate.satisfies(c.getConsequence())) {
								violates = true;
								break;
							}
						}
					}		
					
					if(!violates) {
						newWorlds.add( candidate );
					}
					
				}
	
			}
			
			worlds = newWorlds;
		}		
		
		return worlds.toArray(new Interpretation[worlds.size()]);				
	}
	
	
	/**
	 * Create all possible worlds over a set of interpretable atoms.
	 * @param atoms
	 * @return
	 */
	public Interpretation<I>[] createPossibleWorlds(Collection<I> atoms) {

		LinkedList<Interpretation<I>> worlds = new LinkedList<Interpretation<I>>();
		
		//add empty interpretation
		worlds.add(createEmptyWorld(atoms));
		
		for(I atom: atoms) {
			LinkedList<Interpretation<I>> newWorlds = new LinkedList<Interpretation<I>>();
			
			for(Interpretation<I> partialWorld: worlds) {
				
				//extend partial world to a new world for each possible interpretation of prop
				for(int i=0; i<atom.getNoInterpretations(); i++) {
					
					newWorlds.add( extendWorld(partialWorld,atom,i) );
					
				}
	
			}
			
			worlds = newWorlds;
		}		
		
		return worlds.toArray(new Interpretation[worlds.size()]);				
	}

	protected abstract Interpretation<I> createEmptyWorld(Collection<I> atoms);
	protected abstract Interpretation<I> extendWorld(Interpretation<I> partialWorld, I atom, int value);

}
