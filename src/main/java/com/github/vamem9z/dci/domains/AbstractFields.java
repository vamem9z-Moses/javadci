package main.java.com.github.vamem9z.dci.domains;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Provides shared implementations for hashCode, equals and toString.
 * <p>
 * This class design hinges on the fields() method. 
 * The fields method returns an ArrayList of all of the fields needed to determine equality.
 * It is also used to populate the toString method based on the assumption that the most relevant fields would also be included in the toString method.
 * If that is not the case the toString method can be overridden.
 */
public abstract class AbstractFields {

	/**
	 * Provides a list of the relevant fields of an object. 
	 * <p> 
	 * These fields are those used to determine equality between objects of the same type.
	 */
	public abstract ArrayList<Object> fields();
	
	/**
	 * Uses the fields() method to generate a hash of the object.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return Objects.hash(this.fields());
	}
	
	/**
	 * Uses the fields() method to determine the equality of objects of the same type.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) return true;
		if((obj == null) || (obj.getClass() != this.getClass())) return false;
 		return Objects.deepEquals(this.fields(), this.getClass().cast(obj).fields());
	}
	
	/**
	 * Uses the fields method to print the string representation of the object.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %s", this.getClass().getSimpleName(), this.fields().toString());
	}
}
