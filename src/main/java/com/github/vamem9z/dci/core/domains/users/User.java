package com.github.vamem9z.dci.core.domains.users;

public final class User {
	private final int id;
    private final String name;
    
    public User(int id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
    public final int id() {
    	return this.id;
    }
}


