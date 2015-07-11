package main.dci.domains;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;
import main.dci.domains.AccountDomain.TRANSACTIONTYPES;

@Data
@ToString(includeFieldNames=true)
public class EntryItem {
	private int accountID;
	private String message;
	private ZonedDateTime date;
	private double amount;
	private TRANSACTIONTYPES transactionType;
	
	public EntryItem(int accountID, String message, double amount, TRANSACTIONTYPES transactionType) {
		super();
		this.accountID = accountID;
		this.message = message;
		this.date = ZonedDateTime.now(ZoneOffset.UTC);
		this.amount = amount;
		this.transactionType = transactionType;
	}
}