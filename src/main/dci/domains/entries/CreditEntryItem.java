package main.dci.domains.entries;

public class CreditEntryItem extends EntryItem {
	public CreditEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.CREDIT);
	}
}
