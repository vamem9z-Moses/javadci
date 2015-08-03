package com.github.vamem9z.dci.core.domains.accounts;

import java.time.ZonedDateTime;

import com.github.vamem9z.dci.core.domains.entries.EntryItem;

public interface Account {
	public String printAccountID();
	public int accountId();
	public void recordTransaction(double amount, String msg, AccountActions actions);
	public void recordTransaction(double amount, String msg, AccountActions actions, ZonedDateTime date);
	public void addEntryItem(EntryItem item);
	public double calcBalance();
	
}
