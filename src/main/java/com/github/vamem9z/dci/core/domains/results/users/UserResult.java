package com.github.vamem9z.dci.core.domains.results.users;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public abstract class UserResult extends AbstractResult {

	public UserResult(String name, ResultTypes type) {
		super(name, type);
	}

}
