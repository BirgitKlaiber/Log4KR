package edu.cs.ai.log4KR.gui.trees;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 * This class is used for displaying a knowledge base using a JTree.
 * The default tree looks like the following:
 * 
 * |-Log4KR Objects
 * |  |-Signature
 * |  |-Conditionals
 *   
 * @author koecher
 *
 */
public class Log4KRObjectsTree extends JTree{

	protected DefaultMutableTreeNode root = new DefaultMutableTreeNode("Log4KR Objects");
	protected DefaultMutableTreeNode signatureNode = new DefaultMutableTreeNode("Signature");
	protected DefaultMutableTreeNode conditionalsNode = new DefaultMutableTreeNode("Conditionals");
	
	public Log4KRObjectsTree() {
		this.setCellRenderer(new Log4KRTreeRenderer());
		root.add(signatureNode);
		root.add(conditionalsNode);
		this.setModel(new DefaultTreeModel(root));
	}
}

class Log4KRTreeRenderer extends DefaultTreeCellRenderer{

	ImageIcon predicateIcon;
	ImageIcon constantIcon;
	ImageIcon sortIcon;
	ImageIcon variablesIcon;
	ImageIcon conditionalsIcon;
	ImageIcon knowledgebasesIcon;
	ImageIcon valuesIcon;
	ImageIcon signatureIcon;
	
	public Log4KRTreeRenderer() {
		predicateIcon = createImageIcon("icons/predicates.png");
		constantIcon = createImageIcon("icons/constants.png");
		sortIcon = createImageIcon("icons/sorts.png");
		variablesIcon = createImageIcon("icons/variables.png");
		conditionalsIcon = createImageIcon("icons/conditionals.png");
		knowledgebasesIcon = createImageIcon("icons/knowledgebases.png");
		valuesIcon = createImageIcon("icons/values.png");
		signatureIcon = createImageIcon("icons/signature.png");
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		DefaultMutableTreeNode prevLeaf = (DefaultMutableTreeNode) node.getParent();
		DefaultMutableTreeNode prevPrevLeaf = null;
		
		if(prevLeaf != null){
			prevPrevLeaf = (DefaultMutableTreeNode) prevLeaf.getParent();
		}
		
		setToolTipText(node.toString());
		

		if(prevPrevLeaf != null){
			if(prevPrevLeaf.toString().equals("Constants")){
				setIcon(constantIcon);
			} else if(prevPrevLeaf.toString().equals("Variables")){
				setIcon(variablesIcon);
			} else if(prevPrevLeaf.toString().equals("Conditionals")){
				setIcon(conditionalsIcon);
			} else if(prevPrevLeaf.toString().equals("Signature")){
				setIcon(valuesIcon);
			}
		}
		
		if(prevLeaf != null){
			if(prevLeaf.toString().equals("Predicates")){
				setIcon(predicateIcon);
			} else if(prevLeaf.toString().equals("Constants")){
				setIcon(sortIcon);
			} else if(prevLeaf.toString().equals("Variables")){
				setIcon(sortIcon);
				String tttext = node.toString() + "{";
				for(int i = 0; i < node.getChildCount(); i++){
					tttext += node.getChildAt(i) + ",";
				}
				tttext = tttext.substring(0, tttext.length()-1);
				tttext += "}";
				setToolTipText(tttext);
			} else if(prevLeaf.toString().equals("Conditionals")){
				if(node.getChildCount() == 0){
					setIcon(conditionalsIcon);
				} else {
					setIcon(knowledgebasesIcon);
				}
			} else if(prevLeaf.toString().equals("Signature")){
				setIcon(variablesIcon);
			}
		}
		if(node.toString().equals("Predicates")){
			setIcon(predicateIcon);
			setToolTipText("Predicates");
		} else if(node.toString().equals("Constants")){
			setIcon(constantIcon);
			setToolTipText("Constants");
		} else if(node.toString().equals("Variables")){
			setIcon(variablesIcon);
			setToolTipText("Variables");
		} else if(node.toString().equals("Conditionals")){
			setIcon(conditionalsIcon);
			setToolTipText("Conditionals");
		} else if(node.toString().equals("Signature")){
			setIcon(signatureIcon);
			setToolTipText("Signature");
		}
		
		return c;
	}
	
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Log4KRTreeRenderer.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}