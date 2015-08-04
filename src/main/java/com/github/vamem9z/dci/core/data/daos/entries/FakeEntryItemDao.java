package com.github.vamem9z.dci.core.data.daos.entries;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.entries.DebitEntryItem;
import com.github.vamem9z.dci.core.domains.entries.EntryItem;
import com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.accounts.SavedEntryItem;

public final class FakeEntryItemDao implements EntryItemDao {
	final private ArrayList<EntryItem> entryItems;
	
	public FakeEntryItemDao() {
		this.entryItems = new ArrayList<EntryItem>();
	}
	
	@Override
	public Result save(int id, int accountId, String message, ZonedDateTime date, double amount, TransactionTypes transType) {
		if (id == 0) {
			id = this.randInt(100, 200000);
		}
		
		if (transType == TransactionTypes.DEBIT) {
			DebitEntryItem item = new DebitEntryItem.DebitEntryItemBuilder(accountId, message, amount)
					.id(id)
					.date(date)
					.build();
		
			this.entryItems.add(item);
			return new SavedEntryItem(item);
		}
		
		CreditEntryItem item = new CreditEntryItem.CreditEntryItemBuilder(accountId, message, amount)
				.id(id)
				.date(date)
				.build();
		this.entryItems.add(item);
		return new SavedEntryItem(item);
	}
}