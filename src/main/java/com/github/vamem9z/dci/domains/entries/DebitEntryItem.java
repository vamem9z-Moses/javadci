package main.java.com.github.vamem9z.dci.domains.entries;

public final class DebitEntryItem extends AbstractEntryItem {
	public DebitEntryItem(int accountID, String message, double amount) {
		super(accountID, message, amount, TransactionTypes.DEBIT);
	}
	
	public final double transactionAmount() {
		return -this.amount();
	}
}
