package main.java.com.github.vamem9z.dci.domains.entries;

public class CreditEntryItem extends EntryItem implements EntryItemer {
	public CreditEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.CREDIT);
	}
	
	public double transactionAmount() {
		return this.amount;
	}
}
