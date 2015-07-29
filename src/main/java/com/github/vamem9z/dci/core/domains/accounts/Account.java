package main.java.com.github.vamem9z.dci.core.domains.accounts;

import main.java.com.github.vamem9z.dci.core.domains.entries.EntryItem;

public interface Account {
	public String printAccountID();
	public int accountId();
	public void recordTransaction(double amount, String msg, AccountActions actions);
	public void addEntryItem(EntryItem item);
	public double calcBalance();
	
}
