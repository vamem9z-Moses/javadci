package test.java.com.github.vamem9z.dci.accounts;

import main.java.com.github.vamem9z.dci.domains.accountinfo.types.CheckingAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accountinfo.types.SavingsAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accountinfo.types.VendorAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accounts.types.CheckingAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.SavingsAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.VendorAccount;

public interface AccountTest {
	default CheckingAccount makeCheckingAccount(double startingBalance){
		CheckingAccountInfo acctInfo = new CheckingAccountInfo(123, 12, startingBalance);
		return new CheckingAccount(acctInfo);
	}
	
	default SavingsAccount makeSavingsAccount(double startingBalance) {
		SavingsAccountInfo acctInfo = new SavingsAccountInfo(124,12, startingBalance);
		return new SavingsAccount(acctInfo);
	}
	
	default VendorAccount makeVendorAccount(double startingBalance) {
		VendorAccountInfo acctInfo = new VendorAccountInfo(213, 12, startingBalance);
		return new VendorAccount(acctInfo);
	}
}
