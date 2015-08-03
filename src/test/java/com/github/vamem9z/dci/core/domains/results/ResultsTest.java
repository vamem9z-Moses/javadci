package com.github.vamem9z.dci.core.domains.results;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.core.domains.entries.CreditEntryItem;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;
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
  public void testContextResults(Result ucResult, String expectedName, 
		  ResultTypes expectedType, Class<Result> ucResultParent, 
		  boolean expectedFailure) {
	  
	  assertEquals(ucResult.name(), expectedName);
	  assertEquals(ucResult.resultType(), expectedType);
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
    	new Object[] {new Successful(), "Successful", ResultTypes.SUCCESS, GeneralResult.class, false},
    	new Object[] {new Failed(), "Failed", ResultTypes.FAILURE, GeneralResult.class, true},
    	new Object[] {new WrongContext(), "Wrong Context", ResultTypes.FAILURE, GeneralResult.class, true},
    	new Object[] {new WrongDao(), "Wrong Dao", ResultTypes.FAILURE, GeneralResult.class, true}
    };
  }
  
  public Object[][] accountContextRulesDp() {
	  return new Object[][] {
		  	new Object[] {new NegativeAmountNotAllowed(), "Negative Amount Not Allowed", ResultTypes.FAILURE, AccountResult.class, true},
		  	new Object[] {new SavedEntryItem(new CreditEntryItem(2, "Test", 100.00)), "Saved Entry Item", ResultTypes.SUCCESS, AccountResult.class, false }
	  };
  }
  
  public Object[][] userContextResultsDp() {
	  return new Object[][] {
		  new Object[] { new UserNotFound(), "User Not Found", ResultTypes.FAILURE, UserResult.class, true},
		  new Object[] { new TooManyUsers(), "Too Many Users", ResultTypes.FAILURE, UserResult.class, true},
		  new Object[] { new FoundUser(new User(2, "Test")), "Found User", ResultTypes.SUCCESS, UserResult.class, false}
	  };
  }
  
  public Object[][] productUseCaseResultsDp() {
	  return new Object[][] {
		  new Object[] { new CalculatedInterest(345.00), "Calculated Interest",ResultTypes.SUCCESS, ProductResult.class, false}
	  };
  }
}
