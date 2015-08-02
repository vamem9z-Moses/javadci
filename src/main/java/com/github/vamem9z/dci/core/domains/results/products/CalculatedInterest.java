package com.github.vamem9z.dci.core.domains.results.products;

import java.util.ArrayList;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class CalculatedInterest extends ProductResult {
	private double interest;
	
	public CalculatedInterest(double interest) {
		super("Calculated Interest", ResultTypes.SUCCESS);
		this.interest = interest;
	}
	
	public double calculatedInterest() {
		return interest;
	}
	
	public ArrayList<Object> fields() {
		ArrayList<Object> superFields = super.fields();
		superFields.add(interest);
		return superFields;
	}
}
