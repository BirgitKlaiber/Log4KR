package edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature;


/**
 * A variable has a type and a name. 
 * @author NicoPotyka
 *
 */
public class Variable implements Term {

	
	private Sort type;
	private String name;
	
	

	public Variable(String name, Sort type) {
		this.name = name;
		this.type = type;
	}
	
	
	

	@Override
	public boolean isGround() {
		return false;
	}
	
	
	@Override
	public Sort getType() {
		return type;
	}

	@Override
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

	
}
