package com.github.vamem9z.dci.core.usecases.results.accounts;

import com.github.vamem9z.dci.core.domains.entries.EntryItem;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class SavedEntryItem extends AccountResult {
	final private EntryItem savedEntryItem;
	
	public SavedEntryItem(EntryItem item) {
		super("Saved Entry Item", UseCaseResultTypes.SUCCESS);
		this.savedEntryItem = item;
	}
	
	public EntryItem entryItem() {
		return this.savedEntryItem;
	}
}