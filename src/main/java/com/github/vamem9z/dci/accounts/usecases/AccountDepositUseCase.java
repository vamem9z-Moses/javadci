package com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.results.Result;
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
	public Stream<Result> execute() {
		return execute(this, (UseCase ctx) -> account.deposit((AccountDepositUseCase) ctx), rules);
	}

	@Override
	public void recordTransaction(AccountActions action) {
		account.recordTransaction(amount, message, action);
	}

	@Override
	public double transactionAmount() {
		return amount;
	}

	@Override
	public double currentBalance() {
		return account.calcBalance();
	}
}