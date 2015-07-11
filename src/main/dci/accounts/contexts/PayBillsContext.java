package main.dci.accounts.contexts;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
@NoArgsConstructor
public class PayBillsContext implements Contexter {
	@Getter private TransferMoneySourceRole sourceAccount;
	@Getter private ArrayList<AccountRole> creditors;
	@Getter private double amount;
	
	public void initialize(TransferMoneySourceRole sourceAccount, 
			ArrayList<AccountRole> creditors) {
		this.sourceAccount = sourceAccount;
		this.creditors = creditors;
	}
	
	public ArrayList<ContextResult> execute() {
		return this.sourceAccount.payBills(this);
	}
}