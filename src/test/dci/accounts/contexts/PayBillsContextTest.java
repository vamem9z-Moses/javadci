package test.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import main.dci.accounts.contexts.PayBillsContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.contexts.ContextResult;
import main.dci.domains.products.CheckingAccount;
import main.dci.domains.products.VendorAccount;

@NoArgsConstructor
public class PayBillsContextTest {
	
	
	private static CheckingAccount checkingAccount = new CheckingAccount("Moses", 123, 
			12, 1000.34);
	
	private static VendorAccount vendorAccount1 = new VendorAccount("Vendor 1", 131, 
	            12, 394.30);
	
	private static VendorAccount vendorAccount2 = new VendorAccount("Vendor 2", 131, 
	        12, 122.12);
	
	private ArrayList<AccountRole> creditors = new ArrayList<AccountRole>(Arrays.asList(vendorAccount1, vendorAccount2));
	
	private static PayBillsContext ctx;
	
	@DataProvider(name="testData")
	public Object[][] testData() {
		return new Object[][] {
			{checkingAccount, creditors, ContextResult.SUCCESS, 483.92, 0, 0, "2 liability accounts"},
		};
	}
		
	@Test(dataProvider="testData")
	public void test(TransferMoneySourceRole sourceAccount, ArrayList<AccountRole> creditors, ContextResult expectedResult,
			 double sourceExpected, double vendor1Expected, double vendor2Expected, String testMsg ) {
		double sourceBalance, vendor1Balance, vendor2Balance;
		ctx = new PayBillsContext(sourceAccount, creditors);
		ArrayList<ContextResult> errors = ctx.execute().collect(Collectors.toCollection(ArrayList::new));
		sourceBalance = sourceAccount.getBalance();
		vendor1Balance = creditors.get(0).getBalance();
		vendor2Balance = creditors.get(1).getBalance();
		assertEquals(sourceBalance, sourceExpected, 0, testMsg);
		assertEquals(vendor1Balance, vendor1Expected, 0, testMsg);	
		assertEquals(vendor2Balance, vendor2Expected, 0, testMsg);
		assertEquals(errors.size(), creditors.size());
		errors.stream().forEach(err -> assertEquals(err, expectedResult));
	}
}
