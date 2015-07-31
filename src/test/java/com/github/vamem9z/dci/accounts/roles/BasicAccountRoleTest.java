package com.github.vamem9z.dci.accounts.roles;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.accounts.AccountTest;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.accounts.types.SavingsAccount;

public class BasicAccountRoleTest implements AccountTest {
	
	@DataProvider(name="account test data")
	public Object[][] data(){
		return new Object[][] {
			new Object[] {200.00, AccountActions.DEPOSIT, 300.23, "Credit Test"}, 
			new Object[] {243.23, AccountActions.WITHDRAWAL, -143.00, "Debit Test"}
		};
	}

	@Test(groups = {"unit"}, dataProvider="account test data") 
	public void testGetBalance(double transAmount, AccountActions action, double expectedBalance, String testMessage) {
		SavingsAccount acct = makeSavingsAccount(100.23);
		acct.recordTransaction(transAmount, testMessage, action);
		assertEquals(acct.calcBalance(), expectedBalance, 0.00, testMessage);
	}
}