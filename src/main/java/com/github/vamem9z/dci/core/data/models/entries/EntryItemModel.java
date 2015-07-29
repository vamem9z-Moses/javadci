package main.java.com.github.vamem9z.dci.core.data.models.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.github.vamem9z.dci.core.data.daos.Dao;
import main.java.com.github.vamem9z.dci.core.data.daos.entries.EntryItemDao;
import main.java.com.github.vamem9z.dci.core.data.daos.entries.FakeEntryItemDao;
import main.java.com.github.vamem9z.dci.core.data.models.Model;
import main.java.com.github.vamem9z.dci.core.domains.AbstractFields;
import main.java.com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.core.usecases.results.general.WrongDao;

public final class EntryItemModel extends AbstractFields implements Model{
	private final int id;
	private final int accountID;
	private final String message;
	private final ZonedDateTime date;
	private final double amount;
	private final TransactionTypes transactionType;
	private final EntryItemDao dao;
	
	public EntryItemModel(int id, int accountID, String message, ZonedDateTime time, double amount, TransactionTypes transtype) {
		this(id, accountID, message, time, amount, transtype, new FakeEntryItemDao());
	}
	
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
		
	@Override
	public UseCaseResult save() {
		return this.dao.save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
	}
	
	@Override
	public UseCaseResult save(final Dao dao, final String simpleClassName) {
		if (this.isCorrectDao(dao, simpleClassName)) {
			return new WrongDao();
		}
		return ((EntryItemDao)dao).save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
	}
	
	@Override
	public int id() {
		return this.id;
	}
	
	@Override
	public ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType));
	}
}
