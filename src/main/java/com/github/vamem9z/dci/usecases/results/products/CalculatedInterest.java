package main.java.com.github.vamem9z.dci.usecases.results.products;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

@ToString
@EqualsAndHashCode(callSuper=false)
public final class CalculatedInterest extends ProductResult {
	private double interest;
	
	public CalculatedInterest(double interest) {
		super("Calculated Interest", UseCaseResultTypes.SUCCESS);
		this.interest = interest;
	}
	
	public double calculatedInterest() {
		return interest;
	}
}
