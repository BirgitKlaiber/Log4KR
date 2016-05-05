package edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature;


/**
 * A constant has a sort and a name. 
 * @author NicoPotyka
 *
 */
public class Constant implements Term {

	
	private Sort type;
	private String name;
	

	
	public Constant(String name, Sort type) {
		this.name = name;
		this.type =type;
	}




	@Override
	public boolean isGround() {
		return true;
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
		Constant other = (Constant) obj;
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
