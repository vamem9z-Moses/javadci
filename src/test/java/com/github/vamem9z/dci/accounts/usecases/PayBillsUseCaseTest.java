package com.github.vamem9z.dci.accounts.usecases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.accounts.AccountTest;
import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.usecases.UseCaseTest;

public final class PayBillsUseCaseTest implements UseCaseTest, AccountTest {
	public PayBillsUseCaseTest() {}
	
	private final ArrayList<AccountRole> creditors = new ArrayList<AccountRole>(
			Arrays.asList(makeVendorAccount(394.30), makeVendorAccount(122.12)));
	
	@DataProvider(name="testData")
	public final Object[][] testData() {
		return new Object[][] {
			new Object[]{makeCheckingAccount(1000.34), creditors, new Successful(), 483.92, 0, 0, "2 liability accounts"},
		};
	}
		
	@Test(dataProvider="testData", groups={"unit"})
	public final void test(TransferMoneySourceRole sourceAccount, ArrayList<AccountRole> creditors, Result expectedResult,
			 double sourceExpected, double vendor1Expected, double vendor2Expected, String testMsg ) {
		
		ArrayList<Result> errors = runContext(new PayBillUseCase(
    			sourceAccount, creditors));
		
		assertEquals(sourceAccount.calcBalance(), sourceExpected, 0, testMsg);
		assertEquals(creditors.get(0).calcBalance(), vendor1Expected, 0, testMsg);	
		assertEquals(creditors.get(1).calcBalance(), vendor2Expected, 0, testMsg);
		assertEquals(errors.size(), 2 * creditors.size());
		errors.stream().forEach(err -> assertEquals(err, expectedResult));
	}
}
