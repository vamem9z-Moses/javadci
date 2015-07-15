package test.java.com.github.vamem9z.dci.roles;

import static org.testng.Assert.assertEquals;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeSavingsAccount;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.domains.accounts.types.SavingsAccount;
import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;

@NoArgsConstructor
@ToString
public class BasicAccountRoleTest {

	private static CreditEntryItem creditEntryItem = new CreditEntryItem(123, "Test Credit transaction", 
			200.00);
	private static DebitEntryItem debitEntryItem = new DebitEntryItem(123, "Test Debit transaction", 
			243.23);
	
	@DataProvider(name="account test data")
	public Object[][] data(){
		return new Object[][] {
			{creditEntryItem, 300.23, "Credit Test"}, 
			{debitEntryItem, -143.00, "Debit Test"}
		};
	}

	@Test(dataProvider="account test data",groups={"unit"})
	public void testGetBalance(EntryItem entryItem, double expected, String testMessage) {
		SavingsAccount acct = makeSavingsAccount(100.23);
		acct.getEntries().add(entryItem);
		assertEquals(acct.getBalance(), expected, 0.00, testMessage);
	}
}