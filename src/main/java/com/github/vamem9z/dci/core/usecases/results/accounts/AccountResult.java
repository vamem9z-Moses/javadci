package main.java.com.github.vamem9z.dci.core.usecases.results.accounts;

import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public abstract class AccountResult extends UseCaseResult {
	public AccountResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}
}
