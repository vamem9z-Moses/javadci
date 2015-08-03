package com.github.vamem9z.dci.core.domains.accounts;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import com.github.vamem9z.dci.core.domains.AbstractFields;
import com.github.vamem9z.dci.core.domains.accountinfo.AccountInfo;
import com.github.vamem9z.dci.core.domains.entries.EntryItem;

public abstract class AbstractAccount extends AbstractFields implements Account, AccountRole, TransferMoneySourceRole {
	
	private final AccountInfo accountInfo;
	private final ArrayList<EntryItem> entries;

	public AbstractAccount(AccountInfo acctInfo) {
		super();	
		this.accountInfo = acctInfo;
		
		this.entries = new ArrayList<EntryItem>();
	}
	
	@Override
	public final double calcBalance() {
		double balance = this.accountInfo.startingBalance();
		
		balance = this.entries.stream().reduce(
				balance, 
				(sum, e) -> (sum += e.transactionAmount()), 
				(sum1, sum2)-> sum1 + sum2);
			
		Double precisionBalance = new BigDecimal(new Double(balance)).
				setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return precisionBalance;
	}
	
	@Override
	public final String printAccountID() {
		return this.accountInfo.printAccountID();
	}
	
	@Override
	public final int accountId() {
		return this.accountInfo.accountId();
	}
	
	@Override
	public final void addEntryItem(EntryItem item) {
		this.entries.add(item);
	}
	
	@Override
	public abstract void recordTransaction(double amount, String msg, AccountActions actions);
	
	@Override
	public abstract void recordTransaction(double amount, String msg, AccountActions actions, ZonedDateTime date);
	
	@Override
	public final ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.accountInfo, this.entries));
	}
}