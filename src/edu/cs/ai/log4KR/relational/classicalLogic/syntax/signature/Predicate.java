package edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature;

import java.util.Arrays;



/**
 * A predicate has the form A(t1,...,tn), where ti are term types. A is called the name of the predicate. 
 * If n=0 A is called a proposition. 
 * @author NicoPotyka
 *
 */
public class Predicate {

	
	private String name;
	private Sort[] argumentSorts;
	
	

	public Predicate(String name, Sort... argumentSorts) {
		this.name = name;
		this.argumentSorts = argumentSorts;
	}
	
	

	public int getArity() {
		return argumentSorts.length;
	}
	
	/**
	 * Check validity of arguments.
	 * @param arguments
	 * @return
	 */
	public boolean validArguments(Term[] arguments) {
		
		if(arguments.length != argumentSorts.length) {
			return false;
		}
		
		for(int i=0; i<arguments.length; i++) {
			if(!arguments[i].getType().equals(argumentSorts[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Create string representation.
	 */
	public String toString() {
		StringBuilder stringRep = new StringBuilder(name.length()+7*argumentSorts.length);
		
		stringRep.append(name);
		
		//if predicate has arguments print them.
		if(argumentSorts.length>0) {
			stringRep.append("(");
			for(Sort t: argumentSorts) {
				stringRep.append(t+",");
			}
			//delete last comma
			stringRep.deleteCharAt(stringRep.length()-1);
			stringRep.append(")");
		}
		
		return stringRep.toString();
	}
	
	
	
	
	public String getName() {
		return name;
	}
	



	public Sort[] getArgumentSorts() {
		return argumentSorts;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(argumentSorts);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Predicate other = (Predicate) obj;
		if (!Arrays.equals(argumentSorts, other.argumentSorts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
