package test.java.com.github.vamem9z.dci.accounts;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.com.github.vamem9z.dci.domains.accountinfo.types.CheckingAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accountinfo.types.SavingsAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accountinfo.types.VendorAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accounts.types.CheckingAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.SavingsAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.VendorAccount;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public class TestAccountHelpers {
	public static CheckingAccount makeCheckingAccount(double startingBalance){
		CheckingAccountInfo acctInfo = new CheckingAccountInfo(123, 12, startingBalance);
		return new CheckingAccount(acctInfo);
	}
	
	public static SavingsAccount makeSavingsAccount(double startingBalance) {
		SavingsAccountInfo acctInfo = new SavingsAccountInfo(124,12, startingBalance);
		return new SavingsAccount(acctInfo);
	}
	
	public static VendorAccount makeVendorAccount(double startingBalance) {
		VendorAccountInfo acctInfo = new VendorAccountInfo(213, 12, startingBalance);
		return new VendorAccount(acctInfo);
	}
	
	public static ArrayList<UseCaseResult> runContext(UseCase ctx) {
		return ctx.execute().collect(Collectors.toCollection(ArrayList::new));
	}
}
