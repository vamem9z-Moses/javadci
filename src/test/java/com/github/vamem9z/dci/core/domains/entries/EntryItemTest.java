package com.github.vamem9z.dci.core.domains.entries;

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
		return (CreditEntryItem) new CreditEntryItem.CreditEntryItemBuilder(12, "Test Credit Entry Item", amount).build();
	}
	
	/**
	 * Creates a DebitEntryItem with fake data
	 * @param amount the amount of the transaction
	 * @return new DebitEntryItem with the amount passed in
	 */
	default DebitEntryItem makeDebitEntryItem(double amount) {
		return (DebitEntryItem) new DebitEntryItem.DebitEntryItemBuilder(12, "Test Debit Entry Item", amount).build();
	}
}

