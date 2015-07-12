package main.dci.domains.entries;

public class DebitEntryItem extends EntryItem{
	public DebitEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.DEBIT);
	}
}
