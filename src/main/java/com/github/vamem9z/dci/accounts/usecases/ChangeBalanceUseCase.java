package main.java.com.github.vamem9z.dci.accounts.usecases;

import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;

public interface ChangeBalanceUseCase {
	double transactionAmount();
	void recordTransaction(AccountActions action);
}
