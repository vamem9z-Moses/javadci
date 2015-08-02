package com.github.vamem9z.dci.core.domains.results;

import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.core.domains.AbstractFields;

public abstract class AbstractResult extends AbstractFields { 
	private String name;
	private ResultTypes type;
        
	public AbstractResult(String name, ResultTypes type) {
		this.name = name;
		this.type = type;
	}
	
    public boolean isFailure() {
        if (this.type == ResultTypes.FAILURE) {
        	return true;
        }
        return false;
    }
    
    public final String name() {
    	return this.name;
    }  
    
    public final ResultTypes resultType() {
    	return this.type;
    }
    
    public ArrayList<Object> fields() {
    	return new ArrayList<Object>(Arrays.asList(name, type));
    }
}
