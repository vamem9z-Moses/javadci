package main.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;

@ToString(includeFieldNames=true)
public class PayBillsContext implements Contexter {
	@Getter private TransferMoneySourceRole sourceAccount;
	@Getter private ArrayList<AccountRole> creditors;

	public PayBillsContext(TransferMoneySourceRole sourceAccount, 
			ArrayList<AccountRole> creditors) {
		this.sourceAccount = sourceAccount;
		this.creditors = creditors;
	}
	
	public Stream<ContextResult> execute() {
		return this.sourceAccount.payBills(this);
	}
}