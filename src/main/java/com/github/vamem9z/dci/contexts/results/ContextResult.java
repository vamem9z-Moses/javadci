package main.java.com.github.vamem9z.dci.contexts.results;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class ContextResult { 
	protected String name;
	protected int code;
        
    public static boolean isFailure(ContextResult ctx) {
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
