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
import main.dci.domains.AccountDomain;
import main.dci.domains.AccountDomain.ACCOUNTTYPES;
import main.dci.domains.AccountDomain.PRODUCTTYPES;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransferMoneyContextTest {
	
	private static AccountDomain checkingAccount = new AccountDomain("Moses", 123, 
			12, 1000.34, ACCOUNTTYPES.ASSETACCOUNT, PRODUCTTYPES.CHECKINGACCOUNT);
	
	private static AccountDomain savingsAccount = new AccountDomain("Moses", 124, 
			12, 921.23, ACCOUNTTYPES.ASSETACCOUNT, PRODUCTTYPES.CHECKINGACCOUNT);
	
	private static AccountDomain vendorAccount1 = new AccountDomain("Vendor 1", 131, 
	            12, 394.30, ACCOUNTTYPES.LIABILITYACCOUNT, PRODUCTTYPES.CHECKINGACCOUNT);
	
	private static AccountDomain vendorAccount2 = new AccountDomain("Vendor 2", 131, 
	        12, 122.12, ACCOUNTTYPES.LIABILITYACCOUNT, PRODUCTTYPES.CHECKINGACCOUNT);
	
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
		sourceBalance = sourceAccount.getAccountDomain().getBalance();
		destBalance = destAccount.getAccountDomain().getBalance();
		assertEquals(sourceBalance, sourceExpected, 0, testMsg);
		assertEquals(destBalance, destExpected, 0, testMsg);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0), expectedResult);
	}
}
