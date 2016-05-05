package edu.cs.ai.log4KR.gui.trees;

import java.util.Collection;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader;

/**
 * This class extends the {@link Log4KRObjectsTree} for propositional objects.
 * 
 * @author koecher
 * 
 */
public class Log4KRPropositionalObjectsTree extends Log4KRObjectsTree {
	Collection<PropositionalVariable> variables;
	Map<String, Collection<Conditional<PropositionalVariable>>> knowledgebases;

	DefaultTreeModel treemodel;

	public Log4KRPropositionalObjectsTree() {
		super();

		treemodel = (DefaultTreeModel) this.getModel();
	}

	public void setAll(Log4KRReader reader) {
		if (reader != null) {
			setSignature(reader.getVariables());
			setConditionals(reader.getKnowledgeBases());
		} else {
			setSignature(null);
			setConditionals(null);
		}
	}

	public void setSignature(Collection<PropositionalVariable> variables) {
		this.variables = variables;
		setSignatureNode(variables);
	}

	public void setConditionals(
			Map<String, Collection<Conditional<PropositionalVariable>>> conditionals) {
		this.knowledgebases = conditionals;
		setConditionalsNode(conditionals);
	}

	// NodeSetters

	private void setSignatureNode(Collection<PropositionalVariable> variables) {
		signatureNode.removeAllChildren();
		if (variables != null) {
			// Getting the sorts
			for (PropositionalVariable variable : variables) {
				DefaultMutableTreeNode variableNode = new DefaultMutableTreeNode(
						variable.getName());
				if (variable.getValues() != null) {
					for (String value : variable.getValues()) {
						variableNode.add(new DefaultMutableTreeNode(value));
					}
				}
				signatureNode.add(variableNode);
			}
		} else {
			signatureNode.add(new DefaultMutableTreeNode("none"));
		}

		treemodel.reload();
	}

	private void setConditionalsNode(
			Map<String, Collection<Conditional<PropositionalVariable>>> knowledgebases) {
		conditionalsNode.removeAllChildren();
		if (knowledgebases != null) {
			for (String kb : knowledgebases.keySet()) {
				DefaultMutableTreeNode kbNode = new DefaultMutableTreeNode(kb);
				for (Conditional<PropositionalVariable> c : knowledgebases
						.get(kb)) {
					kbNode.add(new DefaultMutableTreeNode(c));
				}
				conditionalsNode.add(kbNode);
			}
		} else {
			conditionalsNode.add(new DefaultMutableTreeNode("none"));
		}

		treemodel.reload();
	}

	public Collection<PropositionalVariable> getVariables() {
		return variables;
	}

	public Map<String, Collection<Conditional<PropositionalVariable>>> getKnowledgebases() {
		return knowledgebases;
	}

}
