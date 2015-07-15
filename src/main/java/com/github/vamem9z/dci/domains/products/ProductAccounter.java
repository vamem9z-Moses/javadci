package main.java.com.github.vamem9z.dci.domains.products;

import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;

public interface ProductAccounter {
	BasicAccount getAccount();
	double accountInterestRate();
}
