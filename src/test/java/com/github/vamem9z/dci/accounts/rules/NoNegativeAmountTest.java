package com.github.vamem9z.dci.accounts.rules;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.accounts.AccountTest;
import com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.accounts.NegativeAmountNotAllowed;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.domains.results.general.WrongContext;
import com.github.vamem9z.dci.core.usecases.UseCase;

public class NoNegativeAmountTest implements AccountTest {
  @Test(groups = {"unit"}, dataProvider = "dp")
  public void f(UseCase ctx, Result expectedResult, String msg) {
	  NoNegativeAmountsRule rule = new NoNegativeAmountsRule();
	  Result result = rule.action(ctx);
	  assertEquals(result, expectedResult, msg);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { new EmptyTestContext(), new WrongContext(), "Test sending wrong context"},
      new Object[] { new AccountWithdrawUseCase(makeCheckingAccount(100.00), 50.00, "Test withdraw"), 
    		  new Successful(), "Test sending withdraw context"},
      new Object[] { new AccountDepositUseCase(makeCheckingAccount(100.00), 50.00, "Test deposit"), 
    		  new Successful(), "Test sending deposit context"},
      new Object[] { new AccountWithdrawUseCase(makeCheckingAccount(100.00), -50.00, "Test withdraw"), 
    		  new NegativeAmountNotAllowed(), "Test sending withdraw context with negative amount"},
      };
    }
  
 private class EmptyTestContext implements UseCase {
	  public EmptyTestContext() {}
	  public Stream<Result>execute()  {
		  ArrayList<Result> result = new ArrayList<Result>(Arrays.asList(new Successful()));
		  return result.stream();
	  }
  }
}
