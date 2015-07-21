package main.java.com.github.vamem9z.dci.contexts.results.accounts;

import main.java.com.github.vamem9z.dci.contexts.results.Failure;

public final class NegativeAmountNotAllowed extends Failure {
	public NegativeAmountNotAllowed() {
		this.name = "Negative Amount Not Allowed";
		this.code = 301;
	}
}