package test.java.com.github.vamem9z.dci.accounts;

import main.java.com.github.vamem9z.dci.core.domains.accountinfo.types.CheckingAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accountinfo.types.SavingsAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accountinfo.types.VendorAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accounts.types.CheckingAccount;
import main.java.com.github.vamem9z.dci.core.domains.accounts.types.SavingsAccount;
import main.java.com.github.vamem9z.dci.core.domains.accounts.types.VendorAccount;

/**
 * Provides utility methods for creating account test data
 * <p>
 * @author mmiles
 *
 */
public interface AccountTest {
	/**
	 * Creates test checking account with fake AccountInfo.
	 * <p>
	 * @param startingBalance initial balance of the account
	 * @return new CheckingAccount
	 */
	default CheckingAccount makeCheckingAccount(double startingBalance){
		CheckingAccountInfo acctInfo = new CheckingAccountInfo(123, 12, startingBalance);
		return new CheckingAccount(acctInfo);
	}
	/**
	 * Creates test Savings account with fake AccountInfo
	 * <p>
	 * @param startingBalance initial balance of the account
	 * @return new SavingsAccount
	 */
	default SavingsAccount makeSavingsAccount(double startingBalance) {
		SavingsAccountInfo acctInfo = new SavingsAccountInfo(124,12, startingBalance);
		return new SavingsAccount(acctInfo);
	}
	
	/**
	 * Creates test vendor account with fake AccountInfo
	 * <p>
	 * @param startingBalance initial balance of the account
	 * @return new VendorAccount
	 */
	default VendorAccount makeVendorAccount(double startingBalance) {
		VendorAccountInfo acctInfo = new VendorAccountInfo(213, 12, startingBalance);
		return new VendorAccount(acctInfo);
	}
}
