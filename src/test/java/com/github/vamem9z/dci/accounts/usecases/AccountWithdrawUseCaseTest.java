package test.java.com.github.vamem9z.dci.accounts.usecases;

import static org.testng.Assert.assertEquals;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeCheckingAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeSavingsAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeVendorAccount;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.runContext;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.NegativeAmountNotAllowed;

@NoArgsConstructor
public class AccountWithdrawUseCaseTest {
		
    @DataProvider(name="account test data")
    public Object[][] data() {
    	return new Object[][] {
    			new Object[] {makeCheckingAccount(1000.34), new Success(), 400.00, 600.34, "Credit Account Withdraw Test"},
    			new Object[] {makeVendorAccount(1000.34), new Success(), 400.00, 1400.34, "Deposit Account Withdraw Test"},
    			new Object[] {makeSavingsAccount(1000.34), new NegativeAmountNotAllowed(), -400.00, 1000.34, "Negative Amount Credit Account Withdraw Test"},
    			new Object[] {makeVendorAccount(1000.34), new NegativeAmountNotAllowed(), -400.00, 1000.34, "Negative Amount Deposit Account Withdraw Test"}
    	};
    }

    @Test(dataProvider="account test data", groups={"unit"})
	public void test(AccountRole account, UseCaseResult expectedResult, 
			double amount, double expected, String msg) {
    	
            ArrayList<UseCaseResult> errors = runContext(new AccountWithdrawUseCase(
                account,amount, msg));
		
                assertEquals(errors.get(0), expectedResult);    	
                assertEquals(account.calcBalance(), expected, 0.00, msg);
                assertEquals(errors.size(),1);
	}
}