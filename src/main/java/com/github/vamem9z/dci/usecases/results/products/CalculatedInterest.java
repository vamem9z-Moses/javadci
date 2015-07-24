package main.java.com.github.vamem9z.dci.usecases.results.products;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.usecases.results.Success;

@ToString
@EqualsAndHashCode(callSuper=false)
public class CalculatedInterest extends Success {
	private final double interest;
	
	public CalculatedInterest(double interest) {
		this.name = "Calculated Interest";
		this.code = 701;
		this.interest = interest;
	}
	
	public double calculatedInterest() {
		return interest;
	}
}
