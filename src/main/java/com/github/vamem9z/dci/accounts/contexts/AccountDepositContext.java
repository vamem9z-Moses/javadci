package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.rules.Ruler;

public class AccountDepositContext implements Contexter, BalanceChangerContexter {
	private AccountRole account;
	private double amount;
	private String message;
	private ArrayList<Ruler> rules;
	
	public AccountDepositContext(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Ruler>(Arrays.asList(new NoNegativeAmountsRule()));
	}
	
	public Stream<ContextResult> execute() {
		return execute(this, (Contexter ctx) -> this.account.deposit((AccountDepositContext) ctx), this.rules);

	}
	
	public void recordTransaction(AccountActions action) {
		this.account.recordTransaction(this.amount, this.message, action);
	}
	
	public final double transactionAmount() {
		return this.amount;
	}
}