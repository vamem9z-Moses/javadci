package com.github.vamem9z.dci.core.domains.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public final class User {
	private final int id;
    private final String name;
    
    public int id() {
    	return this.id;
    }
}


