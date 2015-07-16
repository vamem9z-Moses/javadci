package test.java.com.github.vamem9z.dci.contexts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Failure;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.contexts.results.WrongContext;
import main.java.com.github.vamem9z.dci.contexts.results.accounts.NegativeAmountNotAllowed;

public class ContextResultTest {
  @Test(dataProvider = "dp", groups={"unit"})
  public void f(ContextResult ctxResult, String expectedName, int expectedCode) {
	  assertEquals(ctxResult.getName(), expectedName);
	  assertEquals(ctxResult.getCode(), expectedCode);
  }
  
  @DataProvider
  public Object[][] dp() {
	  ArrayList<Object[]> results = new ArrayList<Object[]>();
	  results.addAll(Arrays.asList(generalContextRulesDp()));
	  results.addAll(Arrays.asList(accountContextRulesDp()));
	  return results.toArray(new Object[results.size()][]);
  }

  public Object[][] generalContextRulesDp() {
    return new Object[][] {
    	new Object[] {new Success(), "Success", 1},
    	new Object[] {new Failure(), "Failure", 0},
    	new Object[] {new WrongContext(), "Wrong Context", 100}
    };
  }
  
  public Object[][] accountContextRulesDp() {
	  return new Object[][] {
		  	new Object[] {new NegativeAmountNotAllowed(), "Negative Amount Not Allowed", 301}
	  };
  }
}
