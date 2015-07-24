package main.java.com.github.vamem9z.dci.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import lombok.ToString;
import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.data.models.entries.EntryItemModel;
import main.java.com.github.vamem9z.dci.domains.Persister;

@ToString(includeFieldNames=true)
public abstract class AbstractEntryItem implements Persister, EntryItem {
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	
	public AbstractEntryItem(int accountID, String message, double amount, TransactionTypes transtype) {
		super();
		this.accountID = accountID;
		this.message = message;
		this.date = ZonedDateTime.now(ZoneOffset.UTC);
		this.amount = amount;
		this.transactionType = transtype;
	}
	
	protected final double amount() {
		return this.amount;
	}
	
	public final Model createModel() {
		return new EntryItemModel(this.accountID, this.message, this.date, 
				this.amount, this.transactionType);
	}
	
	public abstract double transactionAmount();
}