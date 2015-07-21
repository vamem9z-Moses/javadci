package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import lombok.Getter;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.rules.AccountProtectionRule;
import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.rules.Ruler;

public class AccountWithDrawContext implements Contexter, BalanceChangerContexter {
	/*
	 * Returns a Stream with following possible ContextResult type SUCCESS and
	 * NEGATIVEMAOUNTNOTALLOWED.
	 */
	@Getter private AccountRole account;
	@Getter private double amount;
	@Getter private String message;
	private ArrayList<Ruler> rules;
	
	public AccountWithDrawContext(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Ruler>(Arrays.asList(
				new NoNegativeAmountsRule(), new AccountProtectionRule()));
	}
	
	public Stream<ContextResult>execute(){
		return execute(this, ctx -> this.account.withDraw((AccountWithDrawContext)ctx), this.rules);
	}
	
	public void recordTransaction(AccountActions action) {
		this.account.recordTransaction(this.amount, this.message, action);
	}
}

