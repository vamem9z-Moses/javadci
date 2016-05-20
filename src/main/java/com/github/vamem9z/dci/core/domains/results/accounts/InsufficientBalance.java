package com.github.vamem9z.dci.core.domains.results.accounts;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class InsufficientBalance extends AccountResult {
	public InsufficientBalance() {
		super("Insufficient Balance", ResultTypes.FAILURE);
	}
}
