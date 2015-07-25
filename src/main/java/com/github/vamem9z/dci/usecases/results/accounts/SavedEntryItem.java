package main.java.com.github.vamem9z.dci.usecases.results.accounts;

import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

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