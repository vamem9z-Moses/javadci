package com.github.vamem9z.dci.core.domains.products;

import com.github.vamem9z.dci.core.domains.accounts.Account;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

public abstract class AbstractAccountProduct implements InterestCalculatorRole {
	private final Account account;
	private final double interestRate;
	
	public AbstractAccountProduct(Account account, double interestRate) {
		super();
		this.account = account;
		this.interestRate = interestRate;	
	}
	
	public final double accountInterestRate() {
		return this.interestRate;
	}
	
	public final double calcBalance() {
		return this.account.calcBalance();
	}
	
	public final void recordTransaction(double amount, String msg, AccountActions action) {
		this.account.recordTransaction(amount, msg, action);
	}
}
