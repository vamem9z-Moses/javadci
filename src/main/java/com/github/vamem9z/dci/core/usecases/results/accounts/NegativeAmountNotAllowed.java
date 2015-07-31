package com.github.vamem9z.dci.core.usecases.results.accounts;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class NegativeAmountNotAllowed extends AccountResult {
	public NegativeAmountNotAllowed() {
		super("Negative Amount Not Allowed", UseCaseResultTypes.FAILURE);
	}
}