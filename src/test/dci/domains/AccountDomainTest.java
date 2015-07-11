package test.dci.domains;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import main.dci.domains.AccountDomain;
import main.dci.domains.AccountDomain.ACCOUNTTYPES;
import main.dci.domains.AccountDomain.PRODUCTTYPES;
import main.dci.domains.AccountDomain.TRANSACTIONTYPES;
import main.dci.domains.EntryItem;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountDomainTest {

	private static EntryItem creditEntryItem = new EntryItem(123, "Test Credit transaction", 
			200.00, TRANSACTIONTYPES.CREDIT);
	private static EntryItem debitEntryItem = new EntryItem(123, "Test Debit transaction", 
			243.23, TRANSACTIONTYPES.DEBIT);
	
	@DataProvider(name="account test data")
	public Object[][] data(){
		return new Object[][] {
			{creditEntryItem, 300.23, "Credit Test"}, 
			{debitEntryItem, -143.00, "Debit Test"}
		};
	}

	@Test(dataProvider="account test data")
	public void test(EntryItem entryItem, double expected, String testMessage) {
		AccountDomain accountDomain =  new AccountDomain("Moses", 123, 12, 100.23, 
				ACCOUNTTYPES.ASSETACCOUNT, PRODUCTTYPES.CHECKINGACCOUNT);
		accountDomain.getEntries().add(entryItem);
		double balance = accountDomain.getBalance();
		assertEquals(balance, expected, 0.00, testMessage);
	}
}