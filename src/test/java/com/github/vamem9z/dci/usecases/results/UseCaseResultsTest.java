package test.java.com.github.vamem9z.dci.usecases.results;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.domains.entries.CreditEntryItem;
import main.java.com.github.vamem9z.dci.domains.users.User;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.AccountResult;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.NegativeAmountNotAllowed;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.SavedEntryItem;
import main.java.com.github.vamem9z.dci.usecases.results.general.Failed;
import main.java.com.github.vamem9z.dci.usecases.results.general.GeneralResult;
import main.java.com.github.vamem9z.dci.usecases.results.general.Successful;
import main.java.com.github.vamem9z.dci.usecases.results.general.WrongContext;
import main.java.com.github.vamem9z.dci.usecases.results.products.CalculatedInterest;
import main.java.com.github.vamem9z.dci.usecases.results.products.ProductResult;
import main.java.com.github.vamem9z.dci.usecases.results.users.FoundUser;
import main.java.com.github.vamem9z.dci.usecases.results.users.TooManyUsers;
import main.java.com.github.vamem9z.dci.usecases.results.users.UserNotFound;
import main.java.com.github.vamem9z.dci.usecases.results.users.UserResult;

public class UseCaseResultsTest {
  @Test(dataProvider = "dp", groups={"unit"})
  public void testContextResults(UseCaseResult ucResult, String expectedName, 
		  UseCaseResultTypes expectedType, Class<UseCaseResult> ucResultParent, 
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
    	new Object[] {new Successful(), "Successful", UseCaseResultTypes.SUCCESS, GeneralResult.class, false},
    	new Object[] {new Failed(), "Failed", UseCaseResultTypes.FAILURE, GeneralResult.class, true},
    	new Object[] {new WrongContext(), "Wrong Context", UseCaseResultTypes.FAILURE, GeneralResult.class, true}
    };
  }
  
  public Object[][] accountContextRulesDp() {
	  return new Object[][] {
		  	new Object[] {new NegativeAmountNotAllowed(), "Negative Amount Not Allowed", UseCaseResultTypes.FAILURE, AccountResult.class, true},
		  	new Object[] {new SavedEntryItem(new CreditEntryItem(2, "Test", 100.00)), "Saved Entry Item", UseCaseResultTypes.SUCCESS, AccountResult.class, false }
	  };
  }
  
  public Object[][] userContextResultsDp() {
	  return new Object[][] {
		  new Object[] { new UserNotFound(), "User Not Found", UseCaseResultTypes.FAILURE, UserResult.class, true},
		  new Object[] { new TooManyUsers(), "Too Many Users", UseCaseResultTypes.FAILURE, UserResult.class, true},
		  new Object[] { new FoundUser(new User(2, "Test")), "Found User", UseCaseResultTypes.SUCCESS, UserResult.class, false}
	  };
  }
  
  public Object[][] productUseCaseResultsDp() {
	  return new Object[][] {
		  new Object[] { new CalculatedInterest(345.00), "Calculated Interest",UseCaseResultTypes.SUCCESS, ProductResult.class, false}
	  };
  }
}
