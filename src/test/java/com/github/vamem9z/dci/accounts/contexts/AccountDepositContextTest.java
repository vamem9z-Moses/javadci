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
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.contexts.results.accounts.NegativeAmountNotAllowed;

@NoArgsConstructor
public class AccountDepositContextTest {

    @DataProvider(name="account test data")
    public Object[][] data() {
    	return new Object[][] {
    			new Object[] {makeCheckingAccount(1000.34), new Success(), 400.00, 1400.34, "Credit Account Deposit Test"},
    			new Object[] {makeVendorAccount(1000.34), new Success(), 400.00, 600.34, "Debit Account Deposit Test"},
    			new Object[] {makeSavingsAccount(200.34), new NegativeAmountNotAllowed(), -200.00, 200.34, "Credit Account Negative Amount"},
    			new Object[] {makeVendorAccount(2000.34), new NegativeAmountNotAllowed(), -400.00, 2000.34, "DebitAccount Deposit Test"}
    	};
    }

    @Test(dataProvider="account test data", groups={"unit"})
	public void test(AccountRole account, ContextResult expectedResult, 
			double amount, double expected, String msg) {
    	
            ArrayList<ContextResult> errors = runContext(new AccountDepositContext(
                    account,amount, msg));
        
            assertEquals(errors.get(0), expectedResult);
            assertEquals(account.calcBalance(), expected, 0.00, msg);
            assertEquals(errors.size(), 1);
	}
}