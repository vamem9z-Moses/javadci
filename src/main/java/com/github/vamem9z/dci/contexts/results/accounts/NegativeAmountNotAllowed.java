package main.java.com.github.vamem9z.dci.contexts.results.accounts;

import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;

public final class NegativeAmountNotAllowed extends ContextResult {
	public NegativeAmountNotAllowed() {
		this.name = "Negative Amount Not Allowed";
		this.code = 301;
	}
}