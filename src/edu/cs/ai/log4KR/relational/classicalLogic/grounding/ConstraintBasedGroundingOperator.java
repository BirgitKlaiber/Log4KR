package edu.cs.ai.log4KR.relational.classicalLogic.grounding;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Sort;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * Generates all ground instances that are valid with respect to a set of
 * constraint formulas.
 * 
 * @author NicoPotyka
 *
 */
public class ConstraintBasedGroundingOperator implements GroundingOperator {

	public Collection<RelationalAtom> groundAtoms(Collection<RelationalAtom> atoms, Collection<Constant> consts,
			AtomicConstraint constraint) {

		HashSet<Variable> varSet = new HashSet<Variable>();
		for (RelationalAtom a : atoms) {
			varSet.addAll(a.getVariables());
		}

		Collection<GroundSubstitution> groundSubs = createAllAdmissibleGroundSubstitutions(varSet, consts, constraint);

		HashSet<RelationalAtom> groundAtoms = new HashSet<RelationalAtom>();
		for (RelationalAtom a : atoms) {
			for (GroundSubstitution g : groundSubs) {
				groundAtoms.add((RelationalAtom) a.getGroundFormula(g));
			}
		}

		return groundAtoms;
	}

	@Override
	public Collection<RelationalAtom> groundPredicates(Collection<Predicate> predicates, Collection<Constant> consts) {

		//Generate an atom with new variables for each predicate. Then ground atoms.
		LinkedList<RelationalAtom> atoms = new LinkedList<RelationalAtom>();

		for (Predicate p : predicates) {

			Variable[] args = new Variable[p.getArity()];
			Sort[] sorts = p.getArgumentSorts();
			for (int i = 0; i < p.getArity(); i++) {
				args[i] = new Variable("V_" + p.getName() + "_" + i, sorts[i]);
			}
			atoms.add(new RelationalAtom(p, args));

		}

		return groundAtoms(atoms, consts, null);
	}

	@Override
	public Collection<RelationalConditional> groundKnowledgeBase(Collection<RelationalConditional> conditionals,
			Collection<Constant> consts) {

		HashSet<RelationalConditional> groundKB = new HashSet<RelationalConditional>();

		//ground each conditional 
		for (RelationalConditional c : conditionals) {
			groundKB.addAll(groundConditional(c, consts));
		}

		return groundKB;
	}

	/**
	 * Get all admissible ground conditionals for the passed conditional.
	 * 
	 * @param variables
	 * @return
	 */
	public Collection<RelationalConditional> groundConditional(RelationalConditional cond,
			Collection<Constant> consts) {

		Collection<Atom<RelationalAtom>> atoms = cond.getAtoms();
		Collection<Variable> variables = new HashSet<Variable>();
		for (Atom<RelationalAtom> atom : atoms) {
			variables.addAll(((RelationalAtom) atom).getVariables());
		}

		Collection<GroundSubstitution> groundSubs = createAllAdmissibleGroundSubstitutions(variables, consts,
				cond.getConstraint());

		//create all admissible ground instances
		HashSet<RelationalConditional> groundConditionals = new HashSet<RelationalConditional>();
		for (GroundSubstitution g : groundSubs) {
			groundConditionals.add(g.map(cond));
		}

		return groundConditionals;
	}

	/**
	 * Create all ground substitutions that do not violate constraint formula.
	 * 
	 * @param vars
	 * @param consts
	 * @param constraint
	 * @return
	 */
	private Collection<GroundSubstitution> createAllAdmissibleGroundSubstitutions(Collection<Variable> vars,
			Collection<Constant> consts, Formula<AtomicConstraint> constraint) {

		HashSet<GroundSubstitution> groundSubs = new HashSet<GroundSubstitution>();
		groundSubs.add(new GroundSubstitution());

		//create all ground substitutions
		for (Variable v : vars) {

			HashSet<GroundSubstitution> newGroundSubs = new HashSet<GroundSubstitution>();

			for (Constant c : consts) {

				if (c.getType().equals(v.getType())) {

					for (GroundSubstitution g : groundSubs) {
						GroundSubstitution gNew = new GroundSubstitution(g);
						gNew.mapVarToConst.put(v, c);

						newGroundSubs.add(gNew);
					}
				}
			}

			groundSubs = newGroundSubs;

		}

		//if there is no constraint, all ground substitutions are admissible
		if (constraint == null)
			return groundSubs;

		//otherwise create all admissible ground substitutions
		HashSet<GroundSubstitution> admissibleGroundSubs = new HashSet<GroundSubstitution>();
		for (GroundSubstitution g : groundSubs) {
			if (g.satisfies(constraint)) {
				admissibleGroundSubs.add(g);
			}

		}

		return admissibleGroundSubs;
	}

}
