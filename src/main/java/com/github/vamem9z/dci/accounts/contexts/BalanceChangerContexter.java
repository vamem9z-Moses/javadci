package main.java.com.github.vamem9z.dci.accounts.contexts;

import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;

public interface BalanceChangerContexter {
	double transactionAmount();
	void recordTransaction(AccountActions action);
}
