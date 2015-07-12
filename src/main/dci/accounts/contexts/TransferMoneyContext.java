package main.dci.accounts.contexts;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;

@ToString(includeFieldNames=true)
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
		return execute(this, ctx -> this.sourceAccount.transfer((TransferMoneyContext)ctx)) ;
	}
}