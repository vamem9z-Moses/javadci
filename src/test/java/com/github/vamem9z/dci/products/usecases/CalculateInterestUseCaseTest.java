package com.github.vamem9z.dci.products.usecases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vamem9z.dci.core.domains.products.InterestRateTimePeriod;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.products.CalculatedInterest;
import com.github.vamem9z.dci.core.usecases.UseCaseTest;
import com.github.vamem9z.dci.products.ProductTest;
import com.github.vamem9z.dci.products.roles.InterestCalculatorRole;


public final class CalculateInterestUseCaseTest implements UseCaseTest, ProductTest {
	public CalculateInterestUseCaseTest() {}
	
	@Test(dataProvider="dp", groups={"unit"})
	public final void interestTest(InterestCalculatorRole calc, int amountOfTime,
			InterestRateTimePeriod period, double expectedInterest, 
			double expectedBalance, Result expectedResult, String testMsg) {

			CalculateInterestUseCase uc = new CalculateInterestUseCase(calc, 
					amountOfTime, period);
			ArrayList<Result> results = runContext(uc);
			
			assertEquals(results.size(), 1);
			assertEquals(((CalculatedInterest)results.get(0)).calculatedInterest(),	expectedInterest);
			assertEquals(calc.calcBalance(), expectedBalance);
			assertEquals(results.get(0), expectedResult);		
	}
	
	@DataProvider
	public final Object[][] dp() {
		return new Object[][] {
			new Object[] { makeHighInterestCheckingAccount(100.00, 5.00), 5, InterestRateTimePeriod.DAYS, 0.05, 100.05,  new CalculatedInterest(0.05), "Daily Interest Test" },
			new Object[] { makeHighInterestCheckingAccount(100.00, 5.00), 25, InterestRateTimePeriod.WEEKS, 2.40, 102.40,  new CalculatedInterest(2.40), "Weekly Interest Test" },
			new Object[] { makeHighInterestCheckingAccount(100.00, 5.00), 25, InterestRateTimePeriod.MONTHS, 10.40, 110.40,  new CalculatedInterest(10.40), "Monthly Interest Test" },
			new Object[] { makeHighInterestCheckingAccount(100.00, 5.00), 25, InterestRateTimePeriod.QUARTERS, 31.25, 131.25,  new CalculatedInterest(31.25), "Monthly Interest Test" },
			new Object[] { makeHighInterestCheckingAccount(100.00, 5.00), 25, InterestRateTimePeriod.YEARS, 125.00, 225.00,  new CalculatedInterest(125.00), "Monthly Interest Test" }
		};
	}
}
