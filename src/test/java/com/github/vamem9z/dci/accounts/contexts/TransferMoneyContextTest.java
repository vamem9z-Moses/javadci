package test.java.com.github.vamem9z.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeCheckingAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeSavingsAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeVendorAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.runContext;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.contexts.TransferMoneyContext;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;

@NoArgsConstructor
public class TransferMoneyContextTest {
	
	@DataProvider(name="testData")
	public Object[][] testData() {
		return new Object[][] {
			new Object[]{makeCheckingAccount(1000.34), makeSavingsAccount(921.23), new Success(), 300.00, 700.34, 1221.23, "asset to asset transfer"},
			new Object[]{makeVendorAccount(394.30), makeVendorAccount(122.21), new Success(), 300.00, 694.30, -177.79, "reset test"},
		};
	}
		
	@Test(dataProvider="testData", groups={"unit"})
	public void test(TransferMoneySourceRole sourceAccount, AccountRole destAccount, 
			ContextResult expectedResult,double amount, double sourceExpected, 
			double destExpected, String testMsg ) {
		
		ArrayList<ContextResult> errors = runContext(new TransferMoneyContext(
    			sourceAccount, destAccount, amount));
		
		assertEquals(sourceAccount.calcBalance(), sourceExpected, 0, testMsg);
		assertEquals(destAccount.calcBalance(), destExpected, 0, testMsg);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0), expectedResult);
	}
}
