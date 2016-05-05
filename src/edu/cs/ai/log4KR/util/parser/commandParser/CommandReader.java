package edu.cs.ai.log4KR.util.parser.commandParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import edu.cs.ai.log4KR.propositional.classicalLogic.semantics.PropositionalPossibleWorld64BitRepresentationFactory;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.cmdParser.PropositionalCommandVisitor;
import edu.cs.ai.log4KR.relational.classicalLogic.semantics.RelationalPossibleWorldMapRepresentationFactory;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.cmdParser.RelationalCommandVisitor;
import edu.cs.ai.log4KR.structuredLogics.reasoning.EpistemicState;
import edu.cs.ai.log4KR.structuredLogics.reasoning.OptimumEntropyEpistemicStateLBFGS;


/**
 * This class can be used for:<br>
 * <ul>
 *   <li>reading(running) a .scr file</li>
 *   <li>reading(running) a script from string</li>
 *   <li>TODO:using a command line for executing script commands</li>
 * </ul>
 * @author koecher
 *
 */
public class CommandReader{
	
	protected CommandVisitor<? extends EpistemicState<?>> cmdVisitor;
	
	/**
	 * {@link CommandReader} for propositional knowledge bases.
	 * @param kbreader
	 */
	public CommandReader(edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader kbreader) {
		cmdVisitor = new PropositionalCommandVisitor(kbreader, new PropositionalPossibleWorld64BitRepresentationFactory());
	}
	
	/**
	 * {@link CommandReader} for relational knowledge bases.
	 * @param kbreader
	 */
	public CommandReader(edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader kbreader) {
		cmdVisitor = new RelationalCommandVisitor(kbreader, new RelationalPossibleWorldMapRepresentationFactory());
	}
	
	public static CommandReader getPropositionalCommandReader(){
		return new CommandReader((edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader) null);
	}
	
	public static CommandReader getRelationalCommandReader(){
		return new CommandReader((edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader.Log4KRReader) null);
	}
	
	public void readFromString(String s) {
		cmdVisitor.visitTree(s);
	}
	
	public void read(String path) {
		read(new File(path));
	}

	public void read(File file) {
		try {
			read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void read(InputStream in) {
		Scanner scanner = new Scanner(in);
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		cmdVisitor.visitTree(content);
	}
	
	
	
	public CommandVisitor<? extends EpistemicState<?>> getCmdVisitor() {
		return cmdVisitor;
	}
	
	public Map<String, ? extends OptimumEntropyEpistemicStateLBFGS<?>> getEpStates() {
		return cmdVisitor.getEpStates();
	}

	/**
	 * Execute single commands. Type command followed by ';' into command line and hit enter to run it.
	 * Enter 'exit' to close the application.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		/*
		TODO:
		if(args.length == 0){
			PropositionalCommandReader cmdReader = new PropositionalCommandReader();
			int length = 100;
			byte buffer[] = new byte[length];
		    String input = "";
		    int read;
		    do {
		    	try {
		    		read = System.in.read(buffer, 0, length);
		    		input = new String(buffer, 0, read);
		    		if(input.substring(0, 4).equals("exit")) break;
					cmdReader.readFromString(input);
	    		}
	    		catch(IOException e) {
	    			e.printStackTrace();
	    		} catch (Exception e){
	    			e.printStackTrace();
	    		}
	    	} while(! input.substring(0, 4).equals("exit"));
		}
		*/
	}
	
}
