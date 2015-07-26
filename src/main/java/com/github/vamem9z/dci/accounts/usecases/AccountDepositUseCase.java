package main.java.com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.rules.Rule;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public final class AccountDepositUseCase implements UseCase, ChangeBalanceUseCase {
	private final AccountRole account;
	private final double amount;
	private final String message;
	private final ArrayList<Rule> rules;
	
	public AccountDepositUseCase(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Rule>(Arrays.asList(new NoNegativeAmountsRule()));
	}
	
	@Override
	public Stream<UseCaseResult> execute() {
		return execute(this, (UseCase ctx) -> this.account.deposit((AccountDepositUseCase) ctx), this.rules);
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