package com.github.vamem9z.dci.core.usecases.results.users;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public abstract class UserResult extends UseCaseResult {

	public UserResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}

}
