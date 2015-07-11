package main.dci.accounts.contexts;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
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
	
	public ArrayList<ContextResult> execute() {
		return execute(this, ctx -> this.sourceAccount.transfer((TransferMoneyContext)ctx)) ;
	}
}