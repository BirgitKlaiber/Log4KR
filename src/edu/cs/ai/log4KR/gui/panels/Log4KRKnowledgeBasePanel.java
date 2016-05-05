package edu.cs.ai.log4KR.gui.panels;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

import edu.cs.ai.log4KR.gui.trees.Log4KRObjectsTree;
import edu.cs.ai.log4KR.gui.trees.Log4KRPropositionalObjectsTree;
import edu.cs.ai.log4KR.gui.trees.Log4KRRelationalObjectsTree;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader;

/**
 * This panel contains a TextPane to edit .cl and .rcl files on the left side
 * and a Log4KRObjectsTree on the right side, to display the knowledge base.
 * 
 * @author koecher
 * 
 */

public class Log4KRKnowledgeBasePanel extends JPanel {
	private JScrollPane codeScollPane;
	private JTextPane codePane;
	private File currentFile;
	private JSplitPane splitPane;
	private JScrollPane log4KRObjectsTreeScrollPane;
	private Log4KRObjectsTree log4KRObjTree;

	public Log4KRKnowledgeBasePanel() {

		this.splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setContinuousLayout(true);
		splitPane.setDividerSize(8);
		this.splitPane.setOneTouchExpandable(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addComponent(this.splitPane,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450,
				Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(this.splitPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 260,
				Short.MAX_VALUE));
		this.codeScollPane = new JScrollPane();
		this.splitPane.setLeftComponent(this.codeScollPane);

		this.codePane = new JTextPane() {
			public boolean getScrollableTracksViewportWidth() {
				return getUI().getPreferredSize(this).width <= getParent()
						.getSize().width;
			}
		};
		this.codePane.setFont(new Font("Courier", Font.PLAIN, 13));
		this.codeScollPane.setViewportView(this.codePane);

		log4KRObjectsTreeScrollPane = new JScrollPane();
		splitPane.setRightComponent(log4KRObjectsTreeScrollPane);

		log4KRObjTree = new Log4KRObjectsTree();
		log4KRObjectsTreeScrollPane.setViewportView(log4KRObjTree);
		splitPane.setDividerLocation(0.8);
		setLayout(groupLayout);
	}

	/**
	 * Sets the text pane on the left with the content of the file and displays
	 * the logic in the {@link Log4KRObjectsTree} on the right. The suffix of
	 * the file must be .rcl for relational conditional logic files and .cl for
	 * propositional conditional logic files.
	 * 
	 * @param codeFile
	 */
	public void setTextPane(File codeFile) {
		String extention = "";
		if (codeFile.getName().lastIndexOf(".") > 0) {
			extention = codeFile.getName().substring(
					codeFile.getName().lastIndexOf("."));
		}

		if (extention.equals(".rcl")) {
			Log4KRReader reader = new Log4KRReader();
			reader.read(codeFile);
			Log4KRRelationalObjectsTree relationalTree = new Log4KRRelationalObjectsTree();
			relationalTree.setAll(reader);
			log4KRObjTree = relationalTree;
			log4KRObjectsTreeScrollPane.setViewportView(log4KRObjTree);
		} else if (extention.equals(".cl")) {
			edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader reader = new edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader();
			reader.read(codeFile);
			Log4KRPropositionalObjectsTree propositionalTree = new Log4KRPropositionalObjectsTree();
			propositionalTree.setAll(reader);
			log4KRObjTree = propositionalTree;
			log4KRObjectsTreeScrollPane.setViewportView(log4KRObjTree);
		}

		log4KRObjTree.repaint();

		try {
			codePane.setText(readFile(codeFile));
			currentFile = codeFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public String getCurrentCode() {
		return codePane.getText();
	}

	/**
	 * Is used in {@link #setTextPane(File)} to convert the content of the file
	 * into a string.
	 * 
	 * @param file
	 * @return The content of the file as String.
	 * @throws IOException
	 */
	private String readFile(File file) throws IOException {
		String returnValue = "";
		FileReader fileR = null;

		try {
			fileR = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileR);
			String line = "";
			while ((line = reader.readLine()) != null) {
				returnValue += line + "\n";
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (fileR != null) {
				try {
					fileR.close();
				} catch (IOException e) {
				}
			}
		}
		return returnValue;
	}
}
