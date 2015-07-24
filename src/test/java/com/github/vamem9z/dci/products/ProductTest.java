package test.java.com.github.vamem9z.dci.products;

import main.java.com.github.vamem9z.dci.domains.products.checking.HighInterestCheckingAccount;
import test.java.com.github.vamem9z.dci.accounts.AccountTest;

public interface ProductTest extends AccountTest {
	default HighInterestCheckingAccount makeHighInterestCheckingAccount(double startingBalance, double interestRate) {
		return new HighInterestCheckingAccount(makeCheckingAccount(startingBalance), interestRate); 
	}
}
