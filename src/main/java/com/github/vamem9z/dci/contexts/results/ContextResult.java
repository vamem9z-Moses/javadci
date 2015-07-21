package main.java.com.github.vamem9z.dci.contexts.results;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class ContextResult { 
	@Getter protected String name;
	@Getter protected int code;
        @Getter protected String message;
        
        public static boolean isFailure(ContextResult ctx) {
            if (ctx instanceof Failure) {
                return true;
            }
            return false;
        }
}
