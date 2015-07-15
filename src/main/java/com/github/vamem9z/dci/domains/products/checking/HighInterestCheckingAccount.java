package main.java.com.github.vamem9z.dci.domains.products.checking;

import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;
import main.java.com.github.vamem9z.dci.domains.products.AccountProduct;

public class HighInterestCheckingAccount extends AccountProduct {
	public HighInterestCheckingAccount(BasicAccount account, double interestRate) {
		super(account, interestRate);
	}
}