package test.java.com.github.vamem9z.dci.accounts.rules;

import static org.testng.Assert.assertEquals;
import static test.java.com.github.vamem9z.dci.accounts.TestAccountHelpers.makeCheckingAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.accounts.rules.NoNegativeAmountsRule;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
import main.java.com.github.vamem9z.dci.usecases.results.WrongContext;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.NegativeAmountNotAllowed;

public class NoNegativeAmountTest {
  @Test(groups = {"unit"}, dataProvider = "dp")
  public void f(UseCase ctx, UseCaseResult expectedResult, String msg) {
	  NoNegativeAmountsRule rule = new NoNegativeAmountsRule();
	  UseCaseResult result = rule.action(ctx);
	  assertEquals(result, expectedResult, msg);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { new EmptyTestContext(), new WrongContext(), "Test sending wrong context"},
      new Object[] { new AccountWithdrawUseCase(makeCheckingAccount(100.00), 50.00, "Test withdraw"), 
    		  new Success(), "Test sending withdraw context"},
      new Object[] { new AccountDepositUseCase(makeCheckingAccount(100.00), 50.00, "Test deposit"), 
    		  new Success(), "Test sending deposit context"},
      new Object[] { new AccountWithdrawUseCase(makeCheckingAccount(100.00), -50.00, "Test withdraw"), 
    		  new NegativeAmountNotAllowed(), "Test sending withdraw context with negative amount"},
      };
    }
  
 private class EmptyTestContext implements UseCase {
	  public EmptyTestContext() {}
	  public Stream<UseCaseResult>execute()  {
		  ArrayList<UseCaseResult> result = new ArrayList<UseCaseResult>(Arrays.asList(new Success()));
		  return result.stream();
	  }
  }
}
