package com.github.vamem9z.dci.core.domains.accounts;

import java.time.ZonedDateTime;

import com.github.vamem9z.dci.core.domains.accountinfo.AccountInfo;
import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.entries.DebitEntryItem;

public abstract class AbstractAssetAccount extends AbstractAccount {
	public AbstractAssetAccount(AccountInfo acctInfo) {
		super(acctInfo);
	}
	
	@Override
	public final void recordTransaction(double amount, String msg, AccountActions actions) {
		switch (actions) {
			case DEPOSIT:
				this.addEntryItem(new CreditEntryItem(this.accountId(), msg, amount));
				break;
			case WITHDRAWAL:
				this.addEntryItem(new DebitEntryItem(this.accountId(), msg, amount));
				break;
		}		
	}
	
	@Override
	public final void recordTransaction(double amount, String msg, AccountActions actions, ZonedDateTime date) {
		switch (actions) {
			case DEPOSIT:
				this.addEntryItem(new CreditEntryItem(this.accountId(), msg, date, amount));
				break;
			case WITHDRAWAL:
				this.addEntryItem(new DebitEntryItem(this.accountId(), msg, date, amount));
				break;
		}		
	}
	
}
