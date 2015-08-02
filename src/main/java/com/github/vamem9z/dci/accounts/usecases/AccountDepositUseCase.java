package com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;

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
	public Stream<AbstractResult> execute() {
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