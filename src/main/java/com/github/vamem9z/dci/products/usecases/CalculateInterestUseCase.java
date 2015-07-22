package main.java.com.github.vamem9z.dci.products.usecases;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.domains.products.InterestRateTimePeriod;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public class CalculateInterestUseCase implements UseCase {
	public final InterestCalculatorRole calc;
	public final InterestRateTimePeriod timePeriod;
	
	public CalculateInterestUseCase(InterestCalculatorRole ap, InterestRateTimePeriod timePeriod) {
		this.calc = ap;
		this.timePeriod = timePeriod;
	}
	
	public final Stream<UseCaseResult> execute() {
		return this.calc.calculateInterest(this);
	}
}