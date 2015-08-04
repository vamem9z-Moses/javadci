package com.github.vamem9z.dci.core.domains.entries;

public final class DebitEntryItem extends AbstractEntryItem {
	
	private DebitEntryItem(DebitEntryItemBuilder builder) {
		super(builder);
	}
	
	public static class DebitEntryItemBuilder extends AbstractEntryItem.EntryItemBuilder {

		public DebitEntryItemBuilder(int accountId, String message,
				double amount) {
			super(accountId, message, amount, TransactionTypes.DEBIT);
		}
		
		public EntryItem build() {
			return new DebitEntryItem(this);
		}	
	}
	
	/**
	 * @return signed transaction amount (negative)
	 */
	@Override
	public final double transactionAmount() {
		return -this.amount();
	}

}