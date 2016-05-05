package edu.cs.ai.log4KR.gui.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Sort;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;
import edu.cs.ai.mecore.spirit_grammar.SpiritParser.knowledgebase_return;


/**
 * This class extends the {@link Log4KRObjectsTree} for relational objects.
 * The default tree after using the constructor looks like the following:
 * 
 * |-Log4KR Objects
 * |  |-Signature
 * |  |  |-Constants
 * |  |  |-Variables
 * |  |  |-Predicates
 * |  |-Conditionals
 * 
 * @author koecher
 *
 */
public class Log4KRRelationalObjectsTree extends Log4KRObjectsTree {
	Collection<Constant> constants;
	Collection<Variable> variables;
	Collection<Predicate> predicates;
	Collection<RelationalConditional> conditionals;
	Map<String, Collection<RelationalConditional>> knowledgebases;
	
	DefaultTreeModel treemodel;
	DefaultMutableTreeNode constantsNode = new DefaultMutableTreeNode("Constants");
	DefaultMutableTreeNode variablesNode = new DefaultMutableTreeNode("Variables");
	DefaultMutableTreeNode predicatesNode = new DefaultMutableTreeNode("Predicates");
	
	public Log4KRRelationalObjectsTree() {
		super();
		signatureNode.add(constantsNode);
		signatureNode.add(variablesNode);
		signatureNode.add(predicatesNode);
		
		treemodel = (DefaultTreeModel) this.getModel();
	}

	/**
	 * Sets the whole tree.
	 * @param reader The Log4KRReader. If null, it'll display the root nodes containing 'none'.
	 */
	public void setAll(Log4KRReader reader){
		if(reader!=null){
			setConstants(reader.getConstants());
			setVariables(reader.getVariables());
			setPredicates(reader.getPredicates());
			if(reader.getKnowledgeBases().size() == 0){
				setConditionals(reader.getConditionals());
			} else {
				setConditionals(reader.getKnowledgeBases());
			}
		} else {
			setConstants(null);
			setVariables(null);
			setPredicates(null);
			setConditionals((Collection) null);
		}
	}
	
	/**
	 * Sets {@link Log4KRRelationalObjectsTree#constants} to the given parameter.
	 * @param constants
	 */
	public void setConstants(Collection<Constant> constants){
		this.constants = constants;
		setConstantsNode(constants);
	}
	
	/**
	 * Sets {@link Log4KRRelationalObjectsTree#variables} to the given parameter.
	 * @param variables
	 */
	public void setVariables(Collection<Variable> variables){
		this.variables = variables;
		setVariablesNode(variables);
	}
	
	/**
	 * Sets {@link Log4KRRelationalObjectsTree#predicates} to the given parameter.
	 * @param predicates
	 */
	public void setPredicates(Collection<Predicate> predicates){
		this.predicates = predicates;
		setPredicatesNode(predicates);
	}
	
	/**
	 * Sets the {@link Log4KRRelationalObjectsTree#conditionals} variable and
	 * the conditionals node with the conditionals parameter and sets 
	 * {@link Log4KRRelationalObjectsTree#knowledgebases} variable to null.
	 * @param conditionals
	 */
	public void setConditionals(Collection<RelationalConditional> conditionals){
		this.knowledgebases = null;
		this.conditionals = conditionals;
		setConditionalsNode(conditionals);
	}
	
	/**
	 * Sets the {@link Log4KRRelationalObjectsTree#knowledgebases} variable and
	 * the conditionals node with the knowledgebases parameter and sets
	 * {@link Log4KRRelationalObjectsTree#conditionals} variable to null.
	 * @param knowledgebases
	 */
	public void setConditionals(Map<String, Collection<RelationalConditional>> knowledgebases){
		this.conditionals = null;
		this.knowledgebases = knowledgebases;
		setConditionalsNode(knowledgebases);
	}
	
	// NodeSetters

	/**
	 * Sets the constants node. The first subtree contains all sorts and the sorts contain the constants.
	 * @param constants A collection of constants. If null, it'll display 'none'.
	 */
	private void setConstantsNode(Collection<Constant> constants){
		constantsNode.removeAllChildren();
		if(constants != null){
			//Getting the sorts
			Map<Sort, List<Constant>> sortToConstant = new LinkedHashMap<Sort, List<Constant>>();
			for(Constant c : constants){
				if(!sortToConstant.containsKey(c.getType())){
					sortToConstant.put(c.getType(), new ArrayList<Constant>());
				}
				sortToConstant.get(c.getType()).add(c);
			}
			
			//Creating the treeview
			for(Sort sort : sortToConstant.keySet()){
				DefaultMutableTreeNode sortNode = new DefaultMutableTreeNode(sort);
				for(Constant c : sortToConstant.get(sort)){
					sortNode.add(new DefaultMutableTreeNode(c));
				}
				constantsNode.add(sortNode);
			}
		} else {
			constantsNode.add(new DefaultMutableTreeNode("none"));
		}
	}
	
	/**
	 * Sets the variables node. The first subtree contains all sorts and the sorts contain the variables.
	 * @param variables A collection of variables. If null, it'll display 'none'.
	 */
	private void setVariablesNode(Collection<Variable> variables){
		variablesNode.removeAllChildren();
		if(variables != null){
			//Getting the sorts
			Map<Sort, List<Variable>> sortToVariable = new LinkedHashMap<Sort, List<Variable>>();
			for(Variable v : variables){
				if(!sortToVariable.containsKey(v.getType())){
					sortToVariable.put(v.getType(), new ArrayList<Variable>());
				}
				sortToVariable.get(v.getType()).add(v);
			}
			
			//Creating the treeview
			for(Sort sort : sortToVariable.keySet()){
				DefaultMutableTreeNode sortNode = new DefaultMutableTreeNode(sort);
				for(Variable v : sortToVariable.get(sort)){
					sortNode.add(new DefaultMutableTreeNode(v));
				}
				variablesNode.add(sortNode);
			}
		} else {
			variablesNode.add(new DefaultMutableTreeNode("none"));
		}
	}
	
	/**
	 * Set the predicates node.
	 * @param predicates A Collection of predicates. If null, it'll display 'none'.
	 */
	private void setPredicatesNode(Collection<Predicate> predicates){
		predicatesNode.removeAllChildren();
		if(predicates != null){
			for(Predicate p : predicates){
				predicatesNode.add(new DefaultMutableTreeNode(p));
			}
		} else {
			predicatesNode.add(new DefaultMutableTreeNode("none"));
		}
	}
	
	/**
	 * Sets the conditionals node.
	 * @param conditionals A collection of conditionals. If null, it'll display 'none';
	 */
	private void setConditionalsNode(Collection<RelationalConditional> conditionals){
		conditionalsNode.removeAllChildren();
		if(conditionals != null) {
			for(RelationalConditional c : conditionals){
				conditionalsNode.add(new DefaultMutableTreeNode(c));
			}
		} else {
			conditionalsNode.add(new DefaultMutableTreeNode("none"));
		}
	}
	
	/**
	 * Sets the conditionals node. If parameter knowledgebases is null, the node will display 'none'.
	 * @param knowledgebases A map that has the knowledgebase name as key and a collection of conditionals as value.
	 */
	private void setConditionalsNode(Map<String, Collection<RelationalConditional>> knowledgebases){
		conditionalsNode.removeAllChildren();
		if(knowledgebases != null) {
			for(String kb : knowledgebases.keySet()){
				DefaultMutableTreeNode kbNode = new DefaultMutableTreeNode(kb);
				for(RelationalConditional c : knowledgebases.get(kb)){
					kbNode.add(new DefaultMutableTreeNode(c));
				}
				conditionalsNode.add(kbNode);
			}
		} else {
			conditionalsNode.add(new DefaultMutableTreeNode("none"));
		}
	}
	
	////////////////////////////
	// GETTER //////////////////
	////////////////////////////
	
	public Collection<Constant> getConstants() {
		return constants;
	}

	public Collection<Variable> getVariables() {
		return variables;
	}

	public Collection<Predicate> getPredicates() {
		return predicates;
	}

	public Collection<RelationalConditional> getConditionals() {
		return conditionals;
	}

	public Map<String, Collection<RelationalConditional>> getKnowledgebases() {
		return knowledgebases;
	}
}
