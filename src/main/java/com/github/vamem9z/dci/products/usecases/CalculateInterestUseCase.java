package com.github.vamem9z.dci.products.usecases;

import java.math.BigDecimal;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.products.InterestRateTimePeriod;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

public final class CalculateInterestUseCase implements UseCase {
	private final InterestCalculatorRole calc;
	private final InterestRateTimePeriod timePeriod;
	private final int amountOfTime;
	
	public CalculateInterestUseCase(InterestCalculatorRole ap,  int amountOfTime, InterestRateTimePeriod timePeriod) {
		this.calc = ap;
		this.timePeriod = timePeriod;
		this.amountOfTime = amountOfTime;
	}
	
	public Stream<AbstractResult> execute() {
		return this.calc.calculateInterest(this);
	}
	
	public void recordTransaction(double amount, AccountActions action) {
		this.calc.recordTransaction(amount, 
				String.format("%s Interest", timePeriod.formattedName), 
				AccountActions.DEPOSIT);
	}
	
	public double calculateInterestEarned() {
		double acctBalance = this.calc.calcBalance();
		double rate = this.calc.accountInterestRate()/100;
		
		Double precisionRate = new BigDecimal(new Double(rate)).
				setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		double time = amountOfTime / timePeriod.period;
		Double precisionTime = new BigDecimal(new Double(time)).
				setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		double interest = acctBalance * (precisionRate * precisionTime);
		Double precisionInterest = new BigDecimal(new Double(interest))
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return precisionInterest;
	}
}