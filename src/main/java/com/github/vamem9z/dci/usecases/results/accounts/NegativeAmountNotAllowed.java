package main.java.com.github.vamem9z.dci.usecases.results.accounts;

import main.java.com.github.vamem9z.dci.usecases.results.Failure;

public final class NegativeAmountNotAllowed extends Failure {
	public NegativeAmountNotAllowed() {
		this.name = "Negative Amount Not Allowed";
		this.code = 301;
	}
}