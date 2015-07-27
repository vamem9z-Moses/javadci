package test.java.com.github.vamem9z.dci.entries;

import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;

public interface EntryItemTest {
	default CreditEntryItem makeCreditEntryItem(double amount) {
		return new CreditEntryItem(12, "Test Credit Entry Item", amount);
	}
	
	default DebitEntryItem makeDebitEntryItem(double amount) {
		return new DebitEntryItem(12, "Test Debit Entry Item", amount);
	}
}

