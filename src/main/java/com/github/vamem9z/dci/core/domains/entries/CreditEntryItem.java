package com.github.vamem9z.dci.core.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class CreditEntryItem extends AbstractEntryItem {
	public CreditEntryItem(int id, int accountID, String message, ZonedDateTime date, double amount) {
		super(id, accountID, message, date, amount, TransactionTypes.CREDIT);
	}
	
	public CreditEntryItem(int accountID, String message, double amount) {
		this(DEFAULT_ENTRY_ID, accountID, message, ZonedDateTime.now(ZoneOffset.UTC), amount);
	}
	
	@Override
	public final double transactionAmount() {
		return this.amount();
	}
}
