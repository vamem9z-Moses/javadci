package main.java.com.github.vamem9z.dci.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import lombok.ToString;

@ToString(includeFieldNames=true)
public abstract class EntryItem {
	protected int accountID;
	protected String message;
	protected ZonedDateTime date;
	protected double amount;
	protected TransactionTypes transactionType;
	
	public EntryItem(int accountID, String message, double amount, TransactionTypes transtype) {
		super();
		this.accountID = accountID;
		this.message = message;
		this.date = ZonedDateTime.now(ZoneOffset.UTC);
		this.amount = amount;
		this.transactionType = transtype;
	}
}