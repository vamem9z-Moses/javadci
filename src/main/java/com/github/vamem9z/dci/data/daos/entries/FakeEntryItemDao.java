package main.java.com.github.vamem9z.dci.data.daos.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.SavedEntryItem;

public final class FakeEntryItemDao implements EntryItemDao {
	final private ArrayList<EntryItem> entryItems;
	
	public FakeEntryItemDao() {
		this.entryItems = new ArrayList<EntryItem>();
	}
	
	@Override
	public UseCaseResult save(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType) {
		if (id == 0) {
			id = this.randInt(100, 200000);
		}
		
		if (transType == TransactionTypes.DEBIT) {
			DebitEntryItem item = new DebitEntryItem(id, accountID, message, date, amount);
			this.entryItems.add(item);
			return new SavedEntryItem(item);
		}
		CreditEntryItem item = new CreditEntryItem(id, accountID, message, date, amount);
		this.entryItems.add(item);
		return new SavedEntryItem(item);
	}
	
	public void initialize() {
		this.entryItems.add(new CreditEntryItem(1, 12, "Test CreditEntry", ZonedDateTime.now(ZoneOffset.UTC), 200.00));
		this.entryItems.add(new DebitEntryItem(2, 12, "Test Debit Entry", ZonedDateTime.now(ZoneOffset.UTC), 100.00));
	}
}