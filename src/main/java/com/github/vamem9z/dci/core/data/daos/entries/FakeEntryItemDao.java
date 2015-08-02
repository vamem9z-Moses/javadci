package com.github.vamem9z.dci.core.data.daos.entries;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.entries.DebitEntryItem;
import com.github.vamem9z.dci.core.domains.entries.EntryItem;
import com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.accounts.SavedEntryItem;

public final class FakeEntryItemDao implements EntryItemDao {
	final private ArrayList<EntryItem> entryItems;
	
	public FakeEntryItemDao() {
		this.entryItems = new ArrayList<EntryItem>();
	}
	
	@Override
	public AbstractResult save(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType) {
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