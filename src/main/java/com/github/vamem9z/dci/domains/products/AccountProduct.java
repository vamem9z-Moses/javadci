package main.java.com.github.vamem9z.dci.domains.products;

import main.java.com.github.vamem9z.dci.domains.accounts.Account;

public interface AccountProduct {
	Account account();
	double accountInterestRate();
}
