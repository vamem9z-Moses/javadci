package com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.rules.AccountProtectionRule;
import com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

public final class AccountWithdrawUseCase implements UseCase, ChangeBalanceUseCase {
	/*
	 * Returns a Stream with following possible ContextResult type SUCCESS and
	 * NEGATIVEMAOUNTNOTALLOWED.
	 */
	private final AccountRole account;
	private final double amount;
	private final String message;
	private final ArrayList<Rule> rules;
	
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

