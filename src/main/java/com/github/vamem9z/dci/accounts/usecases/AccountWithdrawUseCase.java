package main.java.com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.rules.AccountProtectionRule;
import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.rules.Rule;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public final class AccountWithdrawUseCase implements UseCase, ChangeBalanceUseCase {
	/*
	 * Returns a Stream with following possible ContextResult type SUCCESS and
	 * NEGATIVEMAOUNTNOTALLOWED.
	 */
	private AccountRole account;
	private double amount;
	private String message;
	private ArrayList<Rule> rules;
	
	public AccountWithdrawUseCase(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Rule>(Arrays.asList(
				new NoNegativeAmountsRule(), new AccountProtectionRule()));
	}
	
	@Override
	public Stream<UseCaseResult>execute(){
		return execute(this, ctx -> this.account.withDraw((AccountWithdrawUseCase)ctx), this.rules);
	}
	
	@Override
	public void recordTransaction(AccountActions action) {
		this.account.recordTransaction(this.amount, this.message, action);
	}
	
	@Override
	public double transactionAmount() {
		return this.amount;
	}
}

