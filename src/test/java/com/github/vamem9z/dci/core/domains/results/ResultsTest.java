package com.github.vamem9z.dci.core.domains.results;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.results.accounts.AccountResult;
import com.github.vamem9z.dci.core.domains.results.accounts.NegativeAmountNotAllowed;
import com.github.vamem9z.dci.core.domains.results.accounts.SavedEntryItem;
import com.github.vamem9z.dci.core.domains.results.general.Failed;
import com.github.vamem9z.dci.core.domains.results.general.GeneralResult;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.domains.results.general.WrongContext;
import com.github.vamem9z.dci.core.domains.results.general.WrongDao;
import com.github.vamem9z.dci.core.domains.results.products.CalculatedInterest;
import com.github.vamem9z.dci.core.domains.results.products.ProductResult;
import com.github.vamem9z.dci.core.domains.results.users.FoundUser;
import com.github.vamem9z.dci.core.domains.results.users.TooManyUsers;
import com.github.vamem9z.dci.core.domains.results.users.UserNotFound;
import com.github.vamem9z.dci.core.domains.results.users.UserResult;
import com.github.vamem9z.dci.core.domains.users.User;

public class ResultsTest {
  @Test(dataProvider = "dp", groups={"unit"})
  public void testContextResults(Result ucResult,
		  String expectedName, Class<Result> ucResultParent,
		  boolean expectedFailure) {

	  assertEquals(ucResult.name(), expectedName);
	  assertTrue(ucResultParent.isInstance(ucResult));
	  assertEquals(ucResult.isFailure(), expectedFailure);
  }

  @DataProvider
  public Object[][] dp() {
	  ArrayList<Object[]> results = new ArrayList<Object[]>();
	  results.addAll(Arrays.asList(generalContextRulesDp()));
	  results.addAll(Arrays.asList(accountContextRulesDp()));
	  results.addAll(Arrays.asList(userContextResultsDp()));
	  results.addAll(Arrays.asList(productUseCaseResultsDp()));
	  return results.toArray(new Object[results.size()][]);
  }

  public Object[][] generalContextRulesDp() {
    return new Object[][] {
    	new Object[] {new Successful(), "Successful", GeneralResult.class, false},
    	new Object[] {new Failed(), "Failed", GeneralResult.class, true},
    	new Object[] {new WrongContext(), "Wrong Context", GeneralResult.class, true},
    	new Object[] {new WrongDao(), "Wrong Dao", GeneralResult.class, true}
    };
  }

  public Object[][] accountContextRulesDp() {
	  return new Object[][] {
		  	new Object[] {new NegativeAmountNotAllowed(), "Negative Amount Not Allowed", AccountResult.class, true},
		  	new Object[] {new SavedEntryItem(new CreditEntryItem.CreditEntryItemBuilder(2, "Test", 100.00).build()),
		  			"Saved Entry Item", AccountResult.class, false }
	  };
  }

  public Object[][] userContextResultsDp() {
	  return new Object[][] {
		  new Object[] { new UserNotFound(), "User Not Found", UserResult.class, true},
		  new Object[] { new TooManyUsers(), "Too Many Users", UserResult.class, true},
		  new Object[] { new FoundUser(new User(2, "Test")), "Found User", UserResult.class, false}
	  };
  }

  public Object[][] productUseCaseResultsDp() {
	  return new Object[][] {
		  new Object[] { new CalculatedInterest(345.00), "Calculated Interest", ProductResult.class, false}
	  };
  }
}
