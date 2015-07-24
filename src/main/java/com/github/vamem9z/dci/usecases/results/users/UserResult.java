package main.java.com.github.vamem9z.dci.usecases.results.users;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public abstract class UserResult extends UseCaseResult {

	public UserResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}

}
