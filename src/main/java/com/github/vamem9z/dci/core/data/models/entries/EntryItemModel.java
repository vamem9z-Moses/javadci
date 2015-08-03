package com.github.vamem9z.dci.core.data.models.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.core.data.daos.Dao;
import com.github.vamem9z.dci.core.data.daos.entries.EntryItemDao;
import com.github.vamem9z.dci.core.data.daos.entries.FakeEntryItemDao;
import com.github.vamem9z.dci.core.data.models.Model;
import com.github.vamem9z.dci.core.domains.AbstractFields;
import com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.general.WrongDao;

/**
 * Model used by EntryItem Domains persist and export data from the system
 * <p>
 * @author mmiles
 *
 */
public final class EntryItemModel extends AbstractFields implements Model{
	private final int id;
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	private final EntryItemDao dao;
	
	/**
	 * Secondary Constructor 
	 * By default it uses the the FakeEntryItemDao.
	 * <p>
	 * @param id unique identifier from the data store
	 * @param accountID unique identifier for the related account
	 * @param message describes the transaction
	 * @param time when the transaction occurred
	 * @param amount amount of the transaction
	 * @param transtype type of the transaction
	 */
	
	public EntryItemModel(int id, int accountID, String message, ZonedDateTime time, double amount, TransactionTypes transtype) {
		this(id, accountID, message, time, amount, transtype, new FakeEntryItemDao());
	}
	
	/**
	 * Secondary Constructor 
	 * By default it uses the the FakeEntryItemDao.
	 * <p>
	 * @param id unique identifier from the data store
	 * @param accountID unique identifier for the related account
	 * @param message describes the transaction
	 * @param time when the transaction occurred
	 * @param amount amount of the transaction
	 * @param transtype type of the transaction
	 * @param dao default dao to be used with this
	 */
	public EntryItemModel(int id, int accountID, String message, ZonedDateTime time, double amount, TransactionTypes transtype, EntryItemDao dao) {
		super();
		this.id = id;
		this.accountID = accountID;
		this.message = message;
		this.date = time;
		this.amount = amount;
		this.transactionType = transtype;
		this.dao = dao;
	}
		
	/**
	 * Uses the default dao to persist this to the data store
	 */
	@Override
	public Result save() {
		return this.dao.save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
	}
	
	/**
	 * Uses the user defined dao to persist this to the data store
	 * <p>
	 * @param dao the dao to be used with this method
	 * @param class the class name of the dao passed in
	 */
	@Override
	public Result save(final Dao dao, final Class<Dao> objClassName) {
		if (this.isCorrectDao(dao, objClassName)) {
			return new WrongDao();
		}
		return ((EntryItemDao)dao).save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
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
