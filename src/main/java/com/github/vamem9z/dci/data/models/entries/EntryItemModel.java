package main.java.com.github.vamem9z.dci.data.models.entries;

import java.time.ZonedDateTime;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.general.Successful;

public final class EntryItemModel implements Model {
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	
	public EntryItemModel(int accountID, String message, ZonedDateTime time, double amount, TransactionTypes transtype) {
		super();
		this.accountID = accountID;
		this.message = message;
		this.date = time;
		this.amount = amount;
		this.transactionType = transtype;
	}
	
	public UseCaseResult save() {
		return new Successful();
	}
}
