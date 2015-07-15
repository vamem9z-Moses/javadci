package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.stream.Stream;

import lombok.Getter;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;

public class TransferMoneyContext implements Contexter {
	@Getter private TransferMoneySourceRole sourceAccount;
	@Getter private AccountRole destAccount;
	@Getter private double amount;
	
	public TransferMoneyContext(TransferMoneySourceRole sourceAccount, 
			AccountRole destAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destAccount = destAccount;
		this.amount = amount;
	}
	
	public Stream<ContextResult> execute() {
		return this.sourceAccount.transfer(this);
	}
}