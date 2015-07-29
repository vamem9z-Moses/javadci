package main.java.com.github.vamem9z.dci.core.domains.products.checking;

import main.java.com.github.vamem9z.dci.core.domains.accounts.Account;
import main.java.com.github.vamem9z.dci.core.domains.products.AbstractAccountProduct;

public final class HighInterestCheckingAccount extends AbstractAccountProduct {
	public HighInterestCheckingAccount(Account account, double interestRate) {
		super(account, interestRate);
	}
}