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
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.contexts.ContextResult;

@NoArgsConstructor
public class AccountWithDrawContextTest {
		
    @DataProvider(name="account test data")
    public Object[][] data() {
    	return new Object[][] {
    			{makeCheckingAccount(1000.34), ContextResult.SUCCESS, 400.00, 600.34, "Credit Account Withdraw Test"},
    			{makeVendorAccount(1000.34), ContextResult.SUCCESS, 400.00, 1400.34, "Deposit Account Withdraw Test"},
    			{makeSavingsAccount(1000.34), ContextResult.FAILURE, -400.00, 1000.34, "Negative Amount Credit Account Withdraw Test"},
    			{makeVendorAccount(1000.34), ContextResult.FAILURE, -400.00, 1000.34, "Negative Amount Deposit Account Withdraw Test"}
    	};
    }

    @Test(dataProvider="account test data")
	public void test(AccountRole account, ContextResult expectedResult, 
			double amount, double expected, String msg) {
    	
    	ArrayList<ContextResult> errors = runContext(new AccountWithDrawContext(
    			account,amount, msg));
    	
		assertEquals(account.getBalance(), expected, 0.00, msg);
		assertEquals(errors.size(),1);
		assertEquals(errors.get(0), expectedResult);
	}
}