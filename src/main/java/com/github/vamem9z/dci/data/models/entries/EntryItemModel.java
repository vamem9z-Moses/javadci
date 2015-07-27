package main.java.com.github.vamem9z.dci.data.models.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.github.vamem9z.dci.data.daos.entries.EntryItemDao;
import main.java.com.github.vamem9z.dci.data.daos.entries.FakeEntryItemDao;
import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.domains.AbstractFields;
import main.java.com.github.vamem9z.dci.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

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
		return dao.save(this.id, this.accountID, this.message, this.date, this.amount, this.transactionType);
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
