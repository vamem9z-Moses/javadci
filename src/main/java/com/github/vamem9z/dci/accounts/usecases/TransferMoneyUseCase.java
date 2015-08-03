package com.github.vamem9z.dci.accounts.usecases;

import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.usecases.UseCase;

public final class TransferMoneyUseCase implements UseCase {
	private final TransferMoneySourceRole sourceAccount;
	private final AccountRole destAccount;
	private final double amount;
	
	public TransferMoneyUseCase(TransferMoneySourceRole sourceAccount, 
			AccountRole destAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destAccount = destAccount;
		this.amount = amount;
	}
	
	@Override
	public Stream<Result> execute() {
		return this.sourceAccount.transfer(this);
	}
	
	public AccountWithdrawUseCase createWithDrawCtx() {
		return new AccountWithdrawUseCase((AccountRole)this.sourceAccount, 
				this.amount, createMsg());	
	}
	
	public AccountDepositUseCase createDepCtx() {
		return new AccountDepositUseCase(this.destAccount, this.amount, createMsg());	
	}
	
	private final String createMsg() {
		return String.format("Transfer From %s to Transfer %s", 
				this.sourceAccount.printAccountID(), this.destAccount.printAccountID()); 
	}
	
}