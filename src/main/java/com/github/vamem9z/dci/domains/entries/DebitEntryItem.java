package main.java.com.github.vamem9z.dci.domains.entries;

public class DebitEntryItem extends EntryItem implements EntryItemer{
	public DebitEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.DEBIT);
	}
	
	public double transactionAmount() {
		return -this.amount;
	}
}
