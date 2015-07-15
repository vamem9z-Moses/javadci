package main.java.com.github.vamem9z.dci.domains.products;

import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

public abstract class AccountProduct implements InterestCalculatorRole {
	public final BasicAccount account;
	public final double interestRate;
	
	public AccountProduct(BasicAccount account, double interestRate) {
		super();
		this.account = account;
		this.interestRate = interestRate;	
	}
	
	public BasicAccount getAccount() {
		return this.account;
	}
	
	public double accountInterestRate() {
		return this.interestRate;
	}
}
