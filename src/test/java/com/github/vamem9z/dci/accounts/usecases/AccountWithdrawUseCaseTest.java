package com.github.vamem9z.dci.accounts.usecases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.accounts.AccountTest;
import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.accounts.NegativeAmountNotAllowed;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.usecases.UseCaseTest;

public final class AccountWithdrawUseCaseTest implements UseCaseTest, AccountTest {
	public AccountWithdrawUseCaseTest() {}

    @DataProvider(name="account test data")
    public final Object[][] data() {
    	return new Object[][] {
    			new Object[] {makeCheckingAccount(1000.34), new Successful(), 400.00, 600.34, "Credit Account Withdraw Test"},
    			new Object[] {makeVendorAccount(1000.34), new Successful(), 400.00, 1400.34, "Deposit Account Withdraw Test"},
    			new Object[] {makeSavingsAccount(1000.34), new NegativeAmountNotAllowed(), -400.00, 1000.34, "Negative Amount Credit Account Withdraw Test"},
    			new Object[] {makeVendorAccount(1000.34), new NegativeAmountNotAllowed(), -400.00, 1000.34, "Negative Amount Deposit Account Withdraw Test"}
    	};
    }

    @Test(dataProvider="account test data", groups={"unit"})
	public final void test(AccountRole account, Result expectedResult, 
			double amount, double expected, String msg) {
    	
            ArrayList<Result> errors = runContext(new AccountWithdrawUseCase(
                account,amount, msg));
		
                assertEquals(errors.get(0), expectedResult);    	
                assertEquals(account.calcBalance(), expected, 0.00, msg);
                assertEquals(errors.size(),1);
	}
}