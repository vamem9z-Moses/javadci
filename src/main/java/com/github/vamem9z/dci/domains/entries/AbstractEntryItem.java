package main.java.com.github.vamem9z.dci.domains.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.data.models.entries.EntryItemModel;
import main.java.com.github.vamem9z.dci.domains.AbstractFields;
import main.java.com.github.vamem9z.dci.domains.Persister;

/**
 * Provides the base implementation of the EntryItem Interface.
 */

public abstract class AbstractEntryItem extends AbstractFields implements Persister, EntryItem {
	private final int id;
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	
	/**
	 * Constructor
	 * <p>
	 * All constructor parameters are required.
	 * 
	 * @param id - unique id in the data store being used. This is pre-filled by the subclass constructor.
	 * @param accountID - unique id of account the entry item belongs  
	 * @param message - message regarding this transaction
	 * @param date - date the transaction was created
	 * @param amount - amount of the transaction
	 * @param transType - the type of the transaction either debit or credit
	 */
	
	public AbstractEntryItem(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType) {
		super();
		this.id  = Objects.requireNonNull(id, "id can't be null");
		this.accountID = Objects.requireNonNull(accountID, "account id can't be null");
		this.message = Objects.requireNonNull(message, "message can't be null");
		this.date = Objects.requireNonNull(date, "date can't be null");
		this.amount = Objects.requireNonNull(amount, "amount can't be null");
		this.transactionType = Objects.requireNonNull(transType, "transacation type can't be null");
	}
	
	/**
	 * Provides subclasses access to the transaction amount.
	 * <p>
	 * @return abs of the transaction amount
	 */
	
	protected final double amount() {
		return this.amount;
	}
	
	/**
	 * Overrides AbstractFields fields() method to create an ArrayList of the key fields in this object.
	 * <p>
	 * @return  all the field values in this object
	 * @see main.java.com.github.vamem9z.dci.domains.AbstractFields#fields()
	 */
	public final ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType));
	}
	
	/**
	 * Overrides Persister Interface createModel() method to create an EntryItem value object that can be persisted.
	 * <p>
	 * @return EntryItemModel populated with all of this object's data fields.
	 * @see main.java.com.github.vamem9z.dci.domains.Persister#createModel()
	 */
	@Override
	public final Model createModel() {
		return new EntryItemModel(this.id, this.accountID, this.message, this.date, 
				this.amount, this.transactionType);
	}

	/**
	 * Provides the "real world" amount either -/+ to allow accounts to calculate their balances.
	 * <p>
	 * @return "real world" transaction amount
	 */
	public abstract double transactionAmount();
}