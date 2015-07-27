package test.java.com.github.vamem9z.dci.entries;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.data.models.entries.EntryItemModel;
import main.java.com.github.vamem9z.dci.domains.entries.AbstractEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.DebitEntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;
import main.java.com.github.vamem9z.dci.domains.entries.TransactionTypes;

public class EntryItemsTest implements EntryItemTest {

	@DataProvider
	public Object[][] amountDp() {
		return new Object[][] {
			{makeCreditEntryItem(100.00), 100.00},
			{makeDebitEntryItem(200.00), -200.00}
		};
	}
	
	@Test(dataProvider="amountDp", groups={"unit"})
	public void testEntryItemTransactionAmounts(EntryItem item, double expectedAmt) {
		assertEquals(item.transactionAmount(), expectedAmt);
	}
	
	@DataProvider
	public Object[][] fieldsDp() {
		return new Object[][] {
			{new CreditEntryItem(1, 1, "Credit Test", 
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00), 
			new ArrayList<Object>(Arrays.asList(1, 1, "Credit Test",
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00, 
					TransactionTypes.CREDIT))},
			{new DebitEntryItem(1, 1, "Debit Test", 
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00), 
			new ArrayList<Object>(Arrays.asList(1, 1, "Debit Test",
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00, 
					TransactionTypes.DEBIT))},
		};
	}
	
	@Test(dataProvider="fieldsDp")
	public void testFields(AbstractEntryItem item, ArrayList<Object> expectedObj) {
		assertTrue(Objects.deepEquals(item.fields(), expectedObj));
	} 
	
	@DataProvider
	public Object[][] createModelDp() {
		return new Object[][] {
			{new CreditEntryItem(1, 1, "Credit Test", 
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00), 
			new EntryItemModel(1, 1, "Credit Test",
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00, 
					TransactionTypes.CREDIT)},
			{new DebitEntryItem(1, 1, "Debit Test", 
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00), 
			new EntryItemModel(1, 1, "Debit Test",
					ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]"), 100.00, 
					TransactionTypes.DEBIT)},
		};
	}
	
	@Test(dataProvider="createModelDp")
	public void testCreateModel(AbstractEntryItem item, EntryItemModel model) {
		assertTrue(item.createModel().equals(model));
	}
}


