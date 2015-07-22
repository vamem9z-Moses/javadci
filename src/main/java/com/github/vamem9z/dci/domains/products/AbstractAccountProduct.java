package main.java.com.github.vamem9z.dci.domains.products;

import main.java.com.github.vamem9z.dci.domains.accounts.Account;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

public abstract class AbstractAccountProduct implements InterestCalculatorRole {
	private final Account account;
	private final double interestRate;
	
	public AbstractAccountProduct(Account account, double interestRate) {
		super();
		this.account = account;
		this.interestRate = interestRate;	
	}
	
	public final Account account() {
		return this.account;
	}
	
	public final double accountInterestRate() {
		return this.interestRate;
	}
}
