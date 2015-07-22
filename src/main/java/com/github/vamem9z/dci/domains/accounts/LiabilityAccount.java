package main.java.com.github.vamem9z.dci.domains.accounts;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;
import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;

public abstract class LiabilityAccount extends Account implements AccountRole, TransferMoneySourceRole{
	public LiabilityAccount(String name, int accountID, int userID, 
			double startingBalance, AccountTypes productCategory) {
		super(name, accountID, userID, startingBalance, productCategory);
	}
	
	public void recordTransaction(double amount, String msg, AccountActions actions) {
		switch (actions) {
			case WITHDRAWAL:
				entries.add(new CreditEntryItem(this.accountInfo.accountId(), msg, amount));
				break;
			case DEPOSIT:
				entries.add(new DebitEntryItem(this.accountInfo.accountId(), msg, amount));
				break;
		}		
	}
}
