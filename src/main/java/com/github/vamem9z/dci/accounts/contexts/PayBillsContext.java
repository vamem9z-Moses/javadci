package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.Contexter;

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