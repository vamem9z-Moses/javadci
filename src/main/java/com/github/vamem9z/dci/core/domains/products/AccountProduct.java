package com.github.vamem9z.dci.core.domains.products;

import com.github.vamem9z.dci.core.domains.accounts.AccountActions;

public interface AccountProduct {
	double accountInterestRate();
	double calcBalance();
	void recordTransaction(double amount, String message, AccountActions action);
}
