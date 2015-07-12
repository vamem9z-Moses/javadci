package test.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import main.dci.accounts.contexts.TransferMoneyContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.domains.accounts.Account;
import main.dci.domains.products.CheckingAccount;
import main.dci.domains.products.SavingsAccount;
import main.dci.domains.products.VendorAccount;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransferMoneyContextTest {
	
	private static Account checkingAccount = new CheckingAccount("Moses", 123, 
			12, 1000.34);
	
	private static Account savingsAccount = new SavingsAccount("Moses", 124, 
			12, 921.23);
	
	private static Account vendorAccount1 = new VendorAccount("Vendor 1", 131, 
	            12, 394.30);
	
	private static Account vendorAccount2 = new VendorAccount("Vendor 2", 131, 
	        12, 122.12);
	
	private static TransferMoneyContext ctx;
	
	@DataProvider(name="testData")
	public Object[][] testData() {
		return new Object[][] {
			{checkingAccount, savingsAccount, ContextResult.SUCCESS, 300.00, 700.34, 1221.23, "asset to asset transfer"},
			{vendorAccount1, vendorAccount2, ContextResult.SUCCESS, 300.00, 694.30, -177.88, "reset test"},
		};
	}
		
	@Test(dataProvider="testData")
	public void test(TransferMoneySourceRole sourceAccount, AccountRole destAccount, 
			ContextResult expectedResult,double amount, double sourceExpected, 
			double destExpected, String testMsg ) {
		double sourceBalance, destBalance;
		ctx = new TransferMoneyContext(sourceAccount, destAccount, amount);
		ArrayList<ContextResult> errors = ctx.execute().collect(Collectors.toCollection(ArrayList::new));
		sourceBalance = sourceAccount.getBalance();
		destBalance = destAccount.getBalance();
		assertEquals(sourceBalance, sourceExpected, 0, testMsg);
		assertEquals(destBalance, destExpected, 0, testMsg);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0), expectedResult);
	}
}
