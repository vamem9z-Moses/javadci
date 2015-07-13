package main.dci.domains.products.checking;

import main.dci.domains.accounts.BasicAccount;
import main.dci.domains.products.AccountProduct;

public class HighIntrestCheckingAccount extends AccountProduct {
	public HighIntrestCheckingAccount(BasicAccount account, double interestRate) {
		super(account, interestRate);
	}
}