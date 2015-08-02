package com.github.vamem9z.dci.core.domains.results.accounts;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public abstract class AccountResult extends AbstractResult {
	public AccountResult(String name, ResultTypes type) {
		super(name, type);
	}
}
