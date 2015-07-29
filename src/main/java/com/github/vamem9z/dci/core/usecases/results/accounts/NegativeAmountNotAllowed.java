package main.java.com.github.vamem9z.dci.core.usecases.results.accounts;

import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class NegativeAmountNotAllowed extends AccountResult {
	public NegativeAmountNotAllowed() {
		super("Negative Amount Not Allowed", UseCaseResultTypes.FAILURE);
	}
}