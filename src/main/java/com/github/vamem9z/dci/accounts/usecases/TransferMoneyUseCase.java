package main.java.com.github.vamem9z.dci.accounts.usecases;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

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
	public Stream<UseCaseResult> execute() {
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