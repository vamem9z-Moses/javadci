package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;

public class TransferMoneyContext implements Contexter {
	private TransferMoneySourceRole sourceAccount;
	private AccountRole destAccount;
	private double amount;
	
	public TransferMoneyContext(TransferMoneySourceRole sourceAccount, 
			AccountRole destAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destAccount = destAccount;
		this.amount = amount;
	}
	
	public Stream<ContextResult> execute() {
		return this.sourceAccount.transfer(this);
	}
	
	public AccountWithDrawContext createWithDrawCtx() {
		return new AccountWithDrawContext((AccountRole)this.sourceAccount, 
				this.amount, createMsg());
		
	}
	
	public AccountDepositContext createDepCtx() {
		return new AccountDepositContext(this.destAccount, this.amount, createMsg());
		
	}
	
	private String createMsg() {
		return String.format("Transfer From %s to Transfer %s", 
				sourceAccount.printAccountID(), destAccount.printAccountID()); 
	}
	
}