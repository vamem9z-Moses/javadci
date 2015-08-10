package com.github.vamem9z.dci.core.data.models.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.core.data.daos.entries.EntryItemDao;
import com.github.vamem9z.dci.core.data.daos.entries.FakeEntryItemDao;
import com.github.vamem9z.dci.core.data.models.Model;
import com.github.vamem9z.dci.core.data.models.ModelBuilder;
import com.github.vamem9z.dci.core.domains.AbstractFields;
import com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import com.github.vamem9z.dci.core.domains.results.Result;

/**
 * Model used by EntryItem Domains persist and export data from the system
 * <p>
 * @author mmiles
 */
public final class EntryItemModel extends AbstractFields implements Model {
	private final int id;
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	private final EntryItemDao dao;
	
	/**
	 * Constructor 
	 * <p>
	 * Called from an EntryModelBuilder using the Fluent Builder Pattern
	 */
	private EntryItemModel(EntryItemModelBuilder builder) {
		super();
		this.id = builder.id;
		this.accountID = builder.accountId;
		this.message = builder.message;
		this.date = builder.date;
		this.amount = builder.amount;
		this.transactionType = builder.transactionType;
		this.dao = builder.dao;
	}
	/**
	 * Constructor 
	 * <p>
	 * Builds an EntryItemModel
	 * By default this will use the FakeEntryItemDao
	 * @param id unique identifier from the data store
	 * @param accountID unique identifier for the related account
	 * @param message describes the transaction
	 * @param time when the transaction occurred
	 * @param amount amount of the transaction
	 * @param transtype type of the transaction
	 * @param dao default dao to be used with this
	 */
	public static class EntryItemModelBuilder implements ModelBuilder<EntryItemModel> {
		public int id;
		public int accountId;
		public String message;
		public ZonedDateTime date;
		public double amount;
		public TransactionTypes transactionType;
		public EntryItemDao dao = new FakeEntryItemDao();
		
		public EntryItemModelBuilder(int id, int accountId, String msg,
				ZonedDateTime date, double amount, TransactionTypes transType) {
			this.id = id;
			this.accountId = accountId;
			this.message = msg;
			this.date = date;
			this.amount = amount;
			this.transactionType = transType;
		}
		
		public EntryItemModelBuilder dao(EntryItemDao dao) {
			this.dao = dao;
			return this;
		}
		
		@Override
		public EntryItemModel build() {
			return new EntryItemModel(this);
		}
	}
		
	/**
	 * Persist this to the data store
	 */
	@Override
	public Result save() {
		return this.dao.save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
	}
	
	/**
	 * Unique identifier of this
	 */
	@Override
	public int id() {
		return this.id;
	}
	
	/**
	 * The fields used to determine equality and this hashcode
	 */
	@Override
	public ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType));
	}
}