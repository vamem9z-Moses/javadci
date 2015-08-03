package com.github.vamem9z.dci.accounts.usecases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.accounts.AccountTest;
import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.usecases.UseCaseTest;

public final class TransferMoneyUseCaseTest implements UseCaseTest, AccountTest {
	public TransferMoneyUseCaseTest() {}
	
	@DataProvider(name="testData")
	public final Object[][] testData() {
		return new Object[][] {
			new Object[]{makeCheckingAccount(1000.34), makeSavingsAccount(921.23), new Successful(), 300.00, 700.34, 1221.23, "asset to asset transfer"},
			new Object[]{makeVendorAccount(394.30), makeVendorAccount(122.21), new Successful(), 300.00, 694.30, -177.79, "reset test"},
		};
	}
		
	@Test(dataProvider="testData", groups={"unit"})
	public final void test(TransferMoneySourceRole sourceAccount, AccountRole destAccount, 
			Result expectedResult,double amount, double sourceExpected, 
			double destExpected, String testMsg ) {
		
		ArrayList<Result> errors = runContext(new TransferMoneyUseCase(
    			sourceAccount, destAccount, amount));
		
		assertEquals(sourceAccount.calcBalance(), sourceExpected, 0, testMsg);
		assertEquals(destAccount.calcBalance(), destExpected, 0, testMsg);
		assertEquals(errors.size(), 2);
		errors.stream().forEach(err -> assertEquals(err, expectedResult));
	}
}
