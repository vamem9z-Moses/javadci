package main.java.com.github.vamem9z.dci.products.contexts;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.domains.products.InterestRateTimePeriod;
import main.java.com.github.vamem9z.dci.products.roles.InterestCalculatorRole;

public class CalculateInterestContext implements Contexter {
	public final InterestCalculatorRole calc;
	public final InterestRateTimePeriod timePeriod;
	
	public CalculateInterestContext(InterestCalculatorRole ap, InterestRateTimePeriod timePeriod) {
		this.calc = ap;
		this.timePeriod = timePeriod;
	}
	
	public Stream<ContextResult> execute() {
		return this.calc.calculateInterest(this);
	}
}