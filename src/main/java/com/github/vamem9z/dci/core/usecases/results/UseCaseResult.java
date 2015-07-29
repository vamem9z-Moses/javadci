package main.java.com.github.vamem9z.dci.core.usecases.results;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public abstract class UseCaseResult { 
	private String name;
	private UseCaseResultTypes type;
        
	public UseCaseResult(String name, UseCaseResultTypes type) {
		this.name = name;
		this.type = type;
	}
	
    public boolean isFailure() {
        if (this.type == UseCaseResultTypes.FAILURE) {
        	return true;
        }
        return false;
    }
    
    public final String name() {
    	return this.name;
    }  
    
    public final UseCaseResultTypes resultType() {
    	return this.type;
    }
}
