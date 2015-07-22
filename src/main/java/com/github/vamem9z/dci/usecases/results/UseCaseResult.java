package main.java.com.github.vamem9z.dci.usecases.results;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class UseCaseResult { 
	protected String name;
	protected int code;
        
    public static boolean isFailure(UseCaseResult ctx) {
        if (ctx instanceof Failure) {
            return true;
        }
        return false;
    }
    
    public final String name() {
    	return this.name;
    }

    public final int code() {
    	return this.code;
    }
       
}
