package com.github.vamem9z.dci.core.domains.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.github.vamem9z.dci.core.data.models.entries.EntryItemModel;
import com.github.vamem9z.dci.core.data.models.entries.EntryItemModel.EntryItemModelBuilder;
import com.github.vamem9z.dci.core.domains.AbstractFields;
import com.github.vamem9z.dci.core.domains.Persistable;

/**
 * Provides the base implementation of the EntryItem Interface.
 */

public abstract class AbstractEntryItem extends AbstractFields implements Persistable<EntryItemModelBuilder>, EntryItem {
	private final int id;
	private final int accountId;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	protected static final int DEFAULT_ENTRY_ID = 0;
	
	/**
	 * Constructor
	 * <p>
	 * All constructor parameters are required.
	 * @param <U>
	 * 
	 * @param id - unique id in the data store being used. This is pre-filled by the subclass constructor.
	 * @param accountID - unique id of account the entry item belongs  
	 * @param message - message regarding this transaction
	 * @param date - date the transaction was created
	 * @param amount - amount of the transaction
	 * @param transType - the type of the transaction either debit or credit
	 */
	
	protected AbstractEntryItem(EntryItemBuilder<? extends AbstractEntryItem> builder) {
		super();
		this.id  = Objects.requireNonNull(builder.id, "id can't be null");
		this.accountId = Objects.requireNonNull(builder.accountId, "account id can't be null");
		this.message = Objects.requireNonNull(builder.message, "message can't be null");
		this.date = Objects.requireNonNull(builder.date, "date can't be null");
		this.amount = Objects.requireNonNull(builder.amount, "amount can't be null");
		this.transactionType = Objects.requireNonNull(builder.transactionType, "transacation type can't be null");
	}
	
	/**
	 * Base EntryItem Builder
	 * <p>
	 * @author mmiles
	 *
	 */
	public static abstract class EntryItemBuilder<T extends AbstractEntryItem> {
		public int id = 0;
		public int accountId;
		public String message;
		public ZonedDateTime date = ZonedDateTime.now(ZoneOffset.UTC);
		public double amount;
		public TransactionTypes transactionType;
		
		public EntryItemBuilder(int accountId, String message, double amount, TransactionTypes type) {
			super();
			this.accountId = accountId;
			this.message = message;
			this.amount = amount;
			this.transactionType = type;
		}
		
		public final EntryItemBuilder<T> id(int id) {
			this.id = id;
			return this;
		}
		
		public final EntryItemBuilder<T> date(ZonedDateTime date) {
			this.date = date;
			return this;
		}
		
		public abstract T build(); 
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
	 * @see com.github.vamem9z.dci.core.domains.AbstractFields#fields()
	 */
	@Override
	public final ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.id, this.accountId, this.message, this.date, this.amount, this.transactionType));
	}
	
	/**
	 * Overrides Persister Interface createModel() method to create an EntryItem value object that can be persisted.
	 * <p>
	 * @return EntryItemModel populated with all of this object's data fields.
	 * @see com.github.vamem9z.dci.core.domains.Persistable#createModel()
	 */
	@Override
	public final EntryItemModelBuilder createModelBuilder() {
		return new EntryItemModel.EntryItemModelBuilder(this.id, this.accountId, this.message, this.date, 
				this.amount, this.transactionType);
	}

	/**
	 * Provides the signed amount either -/+ to allow accounts to calculate their balances.
	 * <p>
	 * @return signed transaction amount
	 */
	@Override
	public abstract double transactionAmount();
}