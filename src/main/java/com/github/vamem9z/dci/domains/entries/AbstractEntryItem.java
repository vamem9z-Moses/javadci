package main.java.com.github.vamem9z.dci.domains.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.data.models.entries.EntryItemModel;
import main.java.com.github.vamem9z.dci.domains.AbstractFields;
import main.java.com.github.vamem9z.dci.domains.Persister;

public abstract class AbstractEntryItem extends AbstractFields implements Persister, EntryItem {
	private final int id;
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	private final ArrayList<Object> fields;
	
	public AbstractEntryItem(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType) {
		super();
		this.id  = id;
		this.accountID = accountID;
		this.message = message;
		this.date = date;
		this.amount = amount;
		this.transactionType = transType;
		this.fields =  new ArrayList<Object>(Arrays.asList(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType));
	}
	
	protected final double amount() {
		return this.amount;
	}
	
	public final ArrayList<Object> fields() {
		return fields;
	}
	
	@Override
	public final Model createModel() {
		return new EntryItemModel(this.accountID, this.message, this.date, 
				this.amount, this.transactionType);
	}

	public abstract double transactionAmount();
}