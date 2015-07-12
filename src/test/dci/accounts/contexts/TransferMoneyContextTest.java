package test.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;
import static test.dci.accounts.TestAccountHelpers.makeCheckingAccount;
import static test.dci.accounts.TestAccountHelpers.makeSavingsAccount;
import static test.dci.accounts.TestAccountHelpers.makeVendorAccount;
import static test.dci.accounts.TestAccountHelpers.runContext;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import main.dci.accounts.contexts.TransferMoneyContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;

@NoArgsConstructor
public class TransferMoneyContextTest {
	
	@DataProvider(name="testData")
	public Object[][] testData() {
		return new Object[][] {
			{makeCheckingAccount(1000.34), makeSavingsAccount(921.23), ContextResult.SUCCESS, 300.00, 700.34, 1221.23, "asset to asset transfer"},
			{makeVendorAccount(394.30), makeVendorAccount(122.21), ContextResult.SUCCESS, 300.00, 694.30, -177.79, "reset test"},
		};
	}
		
	@Test(dataProvider="testData")
	public void test(TransferMoneySourceRole sourceAccount, AccountRole destAccount, 
			ContextResult expectedResult,double amount, double sourceExpected, 
			double destExpected, String testMsg ) {
		
		ArrayList<ContextResult> errors = runContext(new TransferMoneyContext(
    			sourceAccount, destAccount, amount));
		
		assertEquals(sourceAccount.getBalance(), sourceExpected, 0, testMsg);
		assertEquals(destAccount.getBalance(), destExpected, 0, testMsg);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0), expectedResult);
	}
}
