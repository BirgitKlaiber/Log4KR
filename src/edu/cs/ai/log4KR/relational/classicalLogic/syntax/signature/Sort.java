package edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature;

import java.io.Serializable;

/**
 * A sort is just a name. 
 * 
 * @author NicoPotyka
 *
 */
public class Sort implements Serializable {

	
	private static final long serialVersionUID = 6009726102461651217L;
	private final String name;
	
	

	
	public Sort(String name) {
		this.name = name;
	}

	
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Sort other = (Sort) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
}
