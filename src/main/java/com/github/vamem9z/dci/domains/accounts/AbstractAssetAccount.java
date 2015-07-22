package main.java.com.github.vamem9z.dci.domains.accounts;

import main.java.com.github.vamem9z.dci.domains.accountinfo.AccountInfo;
import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;

public abstract class AbstractAssetAccount extends AbstractAccount {
	public AbstractAssetAccount(AccountInfo acctInfo) {
		super(acctInfo);
	}
	
	@Override
	public final void recordTransaction(double amount, String msg, AccountActions actions) {
		switch (actions) {
			case DEPOSIT:
				entries.add(new CreditEntryItem(this.accountInfo.accountId(), msg, amount));
				break;
			case WITHDRAWAL:
				entries.add(new DebitEntryItem(this.accountInfo.accountId(), msg, amount));
				break;
		}		
	}
}
