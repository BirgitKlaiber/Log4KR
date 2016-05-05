package edu.cs.ai.log4KR.propositional.classicalLogic.syntax;

import java.util.Arrays;

import edu.cs.ai.log4KR.logical.syntax.Interpretable;

/**
 * A multivalued propositional variable.
 * 
 * @author NicoPotyka
 *
 */
public class PropositionalVariable implements Interpretable {

	protected String name;
    private String[] values;  

    public String[] getValues() {
		return values;
	}

	
	/**
	 * Create multi-valued propositional variable.
	 * @param name
	 * @param values
	 */
	public PropositionalVariable(String name, String... values) {
		this.name = name;
		this.values = values;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	
	/**
	 * Check whether variable can take value.
	 * @param v
	 * @return
	 */
	public boolean hasValue(String v) {
	
		for(String val: values) {
			if(val.equals(v)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Get i-th value of multi-valued proposition.
	 * @param i
	 * @return
	 */
	public String getValue(int i) {
		if(i<values.length) {
			return values[i];
		}
		else {
			return null;
		}
	}
	
	/**
	 * Returns index of value or null if proposition is binary or does not take this value.
	 * @param i
	 * @return
	 */
	public Integer getValueIndex(String value) {
		
		for(int i=0; i<values.length; i++) {
			if(values[i].equals(value)) return i;
		}
		
		return null;
	}
	
	/**
	 * Get the number of different interpretations (2 for boolean variables, number of values for
	 * multivalued variables).
	 * @return
	 */
	@Override
	public int getNoInterpretations() {
		return values.length;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(values);
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
		PropositionalVariable other = (PropositionalVariable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder(name + "{");
		for(String val : values){
			returnString.append(val+",");
		}
		returnString.deleteCharAt(returnString.length()-1);
		returnString.append("}");
		return returnString.toString();
	}

}
