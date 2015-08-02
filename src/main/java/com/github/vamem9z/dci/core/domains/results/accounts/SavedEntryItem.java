package com.github.vamem9z.dci.core.domains.results.accounts;

import com.github.vamem9z.dci.core.domains.entries.EntryItem;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class SavedEntryItem extends AccountResult {
	final private EntryItem savedEntryItem;
	
	public SavedEntryItem(EntryItem item) {
		super("Saved Entry Item", ResultTypes.SUCCESS);
		this.savedEntryItem = item;
	}
	
	public EntryItem entryItem() {
		return this.savedEntryItem;
	}
}