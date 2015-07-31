package com.github.vamem9z.dci.core.domains.products.checking;

import com.github.vamem9z.dci.core.domains.accounts.Account;
import com.github.vamem9z.dci.core.domains.products.AbstractAccountProduct;

public final class HighInterestCheckingAccount extends AbstractAccountProduct {
	public HighInterestCheckingAccount(Account account, double interestRate) {
		super(account, interestRate);
	}
}