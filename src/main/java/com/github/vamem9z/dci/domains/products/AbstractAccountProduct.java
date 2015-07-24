package main.java.com.github.vamem9z.dci.domains.products;

import main.java.com.github.vamem9z.dci.domains.accounts.Account;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

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
