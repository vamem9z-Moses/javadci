package test.java.com.github.vamem9z.dci.usecases.results;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.domains.users.User;
import main.java.com.github.vamem9z.dci.usecases.results.Failure;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.WrongContext;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.NegativeAmountNotAllowed;
import main.java.com.github.vamem9z.dci.usecases.results.products.CalculatedInterest;
import main.java.com.github.vamem9z.dci.usecases.results.users.FoundUser;
import main.java.com.github.vamem9z.dci.usecases.results.users.TooManyUsers;
import main.java.com.github.vamem9z.dci.usecases.results.users.UserNotFound;

public class UseCaseResultsTest {
  @Test(dataProvider = "dp", groups={"unit"})
  public void testContextResults(UseCaseResult ctxResult, String expectedName, int expectedCode, 
	  Class<UseCaseResult> ctxResultParent) {
	  assertEquals(ctxResult.name(), expectedName);
	  assertEquals(ctxResult.code(), expectedCode);
	  assertTrue(ctxResultParent.isInstance(ctxResult));
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
    	new Object[] {new Success(), "Success", 1, UseCaseResult.class},
    	new Object[] {new Failure(), "Failure", 0, UseCaseResult.class},
    	new Object[] {new WrongContext(), "Wrong Context", 100, Failure.class}
    };
  }
  
  public Object[][] accountContextRulesDp() {
	  return new Object[][] {
		  	new Object[] {new NegativeAmountNotAllowed(), "Negative Amount Not Allowed", 301, Failure.class}
	  };
  }
  
  public Object[][] userContextResultsDp() {
	  return new Object[][] {
		  new Object[] { new UserNotFound(), "User Not Found", 501, Failure.class},
		  new Object[] { new TooManyUsers(), "Too Many Users", 502, Failure.class},
		  new Object[] { new FoundUser(new User()), "Found User", 503, Success.class}
	  };
  }
  
  public Object[][] productUseCaseResultsDp() {
	  return new Object[][] {
		  new Object[] { new CalculatedInterest(345.00), "Calculated Interest", 701, Success.class}
	  };
  }
}
