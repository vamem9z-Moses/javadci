package main.dci.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames=true)
public abstract class EntryItem {
	@Getter protected int accountID;
	@Getter protected String message;
	@Getter protected ZonedDateTime date;
	@Getter protected double amount;
	@Getter protected TransactionTypes transactionType;
	
	public EntryItem(int accountID, String message, double amount, TransactionTypes transtype) {
		super();
		this.accountID = accountID;
		this.message = message;
		this.date = ZonedDateTime.now(ZoneOffset.UTC);
		this.amount = amount;
		this.transactionType = transtype;
	}
}