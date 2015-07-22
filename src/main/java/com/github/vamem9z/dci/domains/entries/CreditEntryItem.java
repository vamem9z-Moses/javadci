package main.java.com.github.vamem9z.dci.domains.entries;

public final class CreditEntryItem extends AbstractEntryItem implements EntryItem {
	public CreditEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.CREDIT);
	}
	
	public final double transactionAmount() {
		return this.amount;
	}
}
