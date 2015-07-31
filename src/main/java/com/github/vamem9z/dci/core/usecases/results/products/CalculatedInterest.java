package com.github.vamem9z.dci.core.usecases.results.products;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

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
