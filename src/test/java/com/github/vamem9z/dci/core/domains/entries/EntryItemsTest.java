package com.github.vamem9z.dci.core.domains.entries;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.core.data.models.entries.EntryItemModel;

/**
 * Tests all of EntryItem domain objects
 */
public final class EntryItemsTest implements EntryItemTest {
	
	public EntryItemsTest() {}
	
	/**
	 * Creates the test data needed to test EntryItem transactionAmount()
	 * <p>
	 * @return an array of Object arrays each containing an EntryItem to test and the expected transaction amount.
	 */
	@DataProvider
	public final Object[][] amountDp() {
		return new Object[][] {
			{makeCreditEntryItem(100.00), 100.00},
			{makeDebitEntryItem(200.00), -200.00}
		};
	}
	
	/**
	 * Tests EntryItem transactionAmount()
	 * <p>
	 * @param item EntryItem currently under test
	 * @param expectedAmt amount expected to return from item transactionAmount()
	 */
	@Test(dataProvider="amountDp", groups={"unit"})
	public void testEntryItemTransactionAmounts(EntryItem item, double expectedAmt) {
		assertEquals(item.transactionAmount(), expectedAmt);
	}

	/**
	 * Creates the test data need to test EntryItem fields()
	 * <p>
	 * @return an array of Object arrays each containing an EntryItem and an array with the same field values as an EntryItem 
	 */
	@DataProvider
	public final Object[][] fieldsDp() {
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

	/**
	 *  Tests the equality of AbstractEntryItem subclasses
	 *  <p>
	 * @param item EntryItem under test
	 * @param expectedObj comparison object under test
	 */
	@Test(dataProvider="fieldsDp", groups={"unit"})
	public final void testFields(AbstractEntryItem item, ArrayList<Object> expectedObj) {
		assertTrue(Objects.deepEquals(item.fields(), expectedObj));
	} 
	
	/**
	 * Creates the test data for testCreateModel
	 * <p>
	 * @return an array of object arrays containing an EntryItem to test and its comparison object
	 */
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
	
	/**
	 * Tests the createModel() for EntryItems
	 * <p>
	 * @param item an AbstractEntryItem under test
	 * @param model the model created by the item
	 */
	
	@Test(dataProvider="createModelDp", groups={"unit"})
	public final void testCreateModel(AbstractEntryItem item, EntryItemModel model) {
		assertTrue(item.createModel().equals(model));
	}
}