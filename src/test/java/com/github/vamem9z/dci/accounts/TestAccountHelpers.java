package test.java.com.github.vamem9z.dci.accounts;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.types.CheckingAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.SavingsAccount;
import main.java.com.github.vamem9z.dci.domains.accounts.types.VendorAccount;

public class TestAccountHelpers {
	public static CheckingAccount makeCheckingAccount(double startingBalance){
		return new CheckingAccount("Moses", 123, 12, startingBalance);
	}
	
	public static SavingsAccount makeSavingsAccount(double startingBalance) {
		return new SavingsAccount("Moses", 124, 12, startingBalance);
	}
	
	public static VendorAccount makeVendorAccount(double startingBalance) {
		return new VendorAccount("Vendor", 235, 90, startingBalance);
	}
	
	public static ArrayList<ContextResult> runContext(Contexter ctx) {
		return ctx.execute().collect(Collectors.toCollection(ArrayList::new));
	}
}
