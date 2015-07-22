package main.java.com.github.vamem9z.dci.domains.accounts;

import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;
import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;

public abstract class AbstractLiabilityAccount extends AbstractAccount {
	public AbstractLiabilityAccount(String name, int accountID, int userID, 
			double startingBalance, AccountTypes productCategory) {
		super(name, accountID, userID, startingBalance, productCategory);
	}
	
	@Override
	public final void recordTransaction(double amount, String msg, AccountActions actions) {
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