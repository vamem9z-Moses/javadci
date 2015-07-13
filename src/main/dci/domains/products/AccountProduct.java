package main.dci.domains.products;

import main.dci.domains.accounts.BasicAccount;

public abstract class AccountProduct {
	public final BasicAccount account;
	public final double interestRate;
	
	public AccountProduct(BasicAccount account, double interestRate) {
		super();
		this.account = account;
		this.interestRate = interestRate;
	}
}
