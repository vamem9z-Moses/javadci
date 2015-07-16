package test.java.com.github.vamem9z.dci.accounts.rules;

import static org.testng.Assert.assertEquals;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeCheckingAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.contexts.results.WrongContext;
import main.java.com.github.vamem9z.dci.contexts.results.accounts.NegativeAmountNotAllowed;

public class NoNegativeAmountTest {
  @Test(groups = {"unit"}, dataProvider = "dp")
  public void f(Contexter ctx, ContextResult expectedResult, String msg) {
	  NoNegativeAmountsRule rule = new NoNegativeAmountsRule();
	  ContextResult result = rule.action(ctx);
	  assertEquals(result, expectedResult, msg);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { new EmptyTestContext(), new WrongContext(), "Test sending wrong context"},
      new Object[] { new AccountWithDrawContext(makeCheckingAccount(100.00), 50.00, "Test withdraw"), 
    		  new Success(), "Test sending withdraw context"},
      new Object[] { new AccountDepositContext(makeCheckingAccount(100.00), 50.00, "Test deposit"), 
    		  new Success(), "Test sending deposit context"},
      new Object[] { new AccountWithDrawContext(makeCheckingAccount(100.00), -50.00, "Test withdraw"), 
    		  new NegativeAmountNotAllowed(), "Test sending withdraw context with negative amount"},
      };
    }
  
 private class EmptyTestContext implements Contexter {
	  public EmptyTestContext() {}
	  public Stream<ContextResult>execute()  {
		  ArrayList<ContextResult> result = new ArrayList<ContextResult>(Arrays.asList(new Success()));
		  return result.stream();
	  }
  }
}
