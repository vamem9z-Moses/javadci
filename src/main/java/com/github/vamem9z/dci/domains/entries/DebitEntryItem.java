package main.java.com.github.vamem9z.dci.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class DebitEntryItem extends AbstractEntryItem {
	public DebitEntryItem(int id, int accountID, String message, ZonedDateTime date, double amount) {
		super(id, accountID, message, date, amount, TransactionTypes.DEBIT);
	}
	
	public DebitEntryItem(int accountID, String message, double amount) {
		this(0, accountID, message, ZonedDateTime.now(ZoneOffset.UTC), amount);
	}

	@Override
	public final double transactionAmount() {
		return -this.amount();
	}
}
