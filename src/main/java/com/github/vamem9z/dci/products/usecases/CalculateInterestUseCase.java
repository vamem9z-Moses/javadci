package main.java.com.github.vamem9z.dci.products.usecases;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.domains.products.InterestRateTimePeriod;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public final class CalculateInterestUseCase implements UseCase {
	private InterestCalculatorRole calc;
	private InterestRateTimePeriod timePeriod;
	
	public CalculateInterestUseCase(InterestCalculatorRole ap, InterestRateTimePeriod timePeriod) {
		this.calc = ap;
		this.timePeriod = timePeriod;
	}
	
	public Stream<UseCaseResult> execute() {
		return this.calc.calculateInterest(this);
	}
	
	public void recordTransaction(double amount, AccountActions action) {
		this.calc.account().recordTransaction(amount, 
				String.format("%s Interest", timePeriod.formattedName), 
				AccountActions.DEPOSIT);
	}
	
	public double calculateInterest() {
		return this.calc.account().calcBalance() / timePeriod.period;
	}
}