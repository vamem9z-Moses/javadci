package test.java.com.github.vamem9z.dci.core.domains.entries;

import main.java.com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.core.domains.entries.DebitEntryItem;

/**
 * Provides utility test methods to assist in testing EntryItems
 * @author mmiles
 *
 */
public interface EntryItemTest {
	/**
	 * Creates a CreditEntryItem with fake data
	 * @param amount the amount of the transaction
	 * @return new CreditEntryItem with the amount passed in
	 */
	default CreditEntryItem makeCreditEntryItem(double amount) {
		return new CreditEntryItem(12, "Test Credit Entry Item", amount);
	}
	
	/**
	 * Creates a DebitEntryItem with fake data
	 * @param amount the amount of the transaction
	 * @return new DebitEntryItem with the amount passed in
	 */
	default DebitEntryItem makeDebitEntryItem(double amount) {
		return new DebitEntryItem(12, "Test Debit Entry Item", amount);
	}
}

