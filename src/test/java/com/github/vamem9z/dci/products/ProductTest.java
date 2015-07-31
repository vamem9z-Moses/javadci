package com.github.vamem9z.dci.products;

import com.github.vamem9z.dci.core.domains.products.checking.HighInterestCheckingAccount;
import com.github.vamem9z.dci.accounts.AccountTest;

public interface ProductTest extends AccountTest {
	default HighInterestCheckingAccount makeHighInterestCheckingAccount(double startingBalance, double interestRate) {
		return new HighInterestCheckingAccount(makeCheckingAccount(startingBalance), interestRate); 
	}
}
