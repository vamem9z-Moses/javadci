package main.java.com.github.vamem9z.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;

public class PayBillsContext implements Contexter {
	private TransferMoneySourceRole sourceAccount;
	private ArrayList<AccountRole> creditors;

	public PayBillsContext(TransferMoneySourceRole sourceAccount, 
			ArrayList<AccountRole> creditors) {
		this.sourceAccount = sourceAccount;
		this.creditors = creditors;
	}
	
	public Stream<ContextResult> execute() {
		return this.sourceAccount.payBills(this);
	}
	
	public final TransferMoneySourceRole sourceAccount() {
		return this.sourceAccount;
	}
	
	public final ArrayList<AccountRole> creditors() {
		return this.creditors;
	}
}