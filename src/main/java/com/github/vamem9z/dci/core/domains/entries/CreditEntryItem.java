package com.github.vamem9z.dci.core.domains.entries;

public final class CreditEntryItem extends AbstractEntryItem {
	
	private CreditEntryItem(CreditEntryItemBuilder builder) {
		super(builder);
	}
	
	/**
	 * Builder for CreditEntryItems
	 * <p>
	 * @author mmiles
	 *
	 */
	public static class CreditEntryItemBuilder extends AbstractEntryItem.EntryItemBuilder<CreditEntryItem> {

		public CreditEntryItemBuilder(int accountId, String message,
				double amount) {
			super(accountId, message, amount, TransactionTypes.CREDIT);
		}
		
		public CreditEntryItem build() {
			return new CreditEntryItem(this);
		}	
	}
	
	/**
	 * @return signed transaction amount (positive)
	 */
	@Override
	public final double transactionAmount() {
		return this.amount();
	}

}