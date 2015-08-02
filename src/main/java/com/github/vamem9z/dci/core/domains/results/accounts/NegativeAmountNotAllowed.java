package com.github.vamem9z.dci.core.domains.results.accounts;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class NegativeAmountNotAllowed extends AccountResult {
	public NegativeAmountNotAllowed() {
		super("Negative Amount Not Allowed", ResultTypes.FAILURE);
	}
}