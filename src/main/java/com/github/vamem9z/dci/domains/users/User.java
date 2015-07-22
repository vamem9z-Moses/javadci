package main.java.com.github.vamem9z.dci.domains.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class User {
	private int id;
    private String name;
    
    public final int id() {
    	return this.id;
    }
}


