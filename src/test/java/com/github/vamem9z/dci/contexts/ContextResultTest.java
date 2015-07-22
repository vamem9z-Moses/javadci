package test.java.com.github.vamem9z.dci.contexts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Failure;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.contexts.results.WrongContext;
import main.java.com.github.vamem9z.dci.contexts.results.accounts.NegativeAmountNotAllowed;
import main.java.com.github.vamem9z.dci.contexts.results.users.FoundUser;
import main.java.com.github.vamem9z.dci.contexts.results.users.TooManyUsers;
import main.java.com.github.vamem9z.dci.contexts.results.users.UserNotFound;
import main.java.com.github.vamem9z.dci.domains.users.User;

public class ContextResultTest {
  @Test(dataProvider = "dp", groups={"unit"})
  public void testContextResults(ContextResult ctxResult, String expectedName, int expectedCode, 
	  Class<ContextResult> ctxResultParent) {
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
	  return results.toArray(new Object[results.size()][]);
  }

  public Object[][] generalContextRulesDp() {
    return new Object[][] {
    	new Object[] {new Success(), "Success", 1, ContextResult.class},
    	new Object[] {new Failure(), "Failure", 0, ContextResult.class},
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
}
