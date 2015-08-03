package com.github.vamem9z.dci.core.domains.accounts;

import java.time.ZonedDateTime;

import com.github.vamem9z.dci.core.domains.accountinfo.AccountInfo;
import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.entries.DebitEntryItem;

public abstract class AbstractLiabilityAccount extends AbstractAccount {
	public AbstractLiabilityAccount(AccountInfo acctInfo) {
		super(acctInfo);
	}
	
	@Override
	public final void recordTransaction(double amount, String msg, AccountActions actions) {
		switch (actions) {
			case WITHDRAWAL:
				this.addEntryItem(new CreditEntryItem(this.accountId(), msg, amount));
				break;
			case DEPOSIT:
				this.addEntryItem(new DebitEntryItem(this.accountId(), msg, amount));
				break;
		}		
	}
	
	public final void recordTransaction(double amount, String msg, AccountActions actions, ZonedDateTime date) {
		switch (actions) {
			case WITHDRAWAL:
				this.addEntryItem(new CreditEntryItem(this.accountId(), msg, date, amount));
				break;
			case DEPOSIT:
				this.addEntryItem(new DebitEntryItem(this.accountId(), msg, date, amount));
				break;
		}		
	}
}
