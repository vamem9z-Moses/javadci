package com.github.vamem9z.dci.core.domains.results;

import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.core.domains.AbstractFields;

public abstract class AbstractResult extends AbstractFields implements Result {
	private String name;
	private ResultTypes type;

	public AbstractResult(String name, ResultTypes type) {
		this.name = name;
		this.type = type;
	}

    @Override
	public final boolean isFailure() {
        if (this.type == ResultTypes.FAILURE) {
        	return true;
        }
        return false;
    }

    @Override
	public final String name() {
    	return this.name;
    }

    @Override
	public ArrayList<Object> fields() {
    	return new ArrayList<Object>(Arrays.asList(name, type));
    }
}
