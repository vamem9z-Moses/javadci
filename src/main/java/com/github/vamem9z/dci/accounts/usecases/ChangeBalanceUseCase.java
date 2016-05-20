package com.github.vamem9z.dci.accounts.usecases;

import com.github.vamem9z.dci.core.domains.accounts.AccountActions;

public interface ChangeBalanceUseCase {
	double transactionAmount();
	double currentBalance();
	void recordTransaction(AccountActions action);
}
