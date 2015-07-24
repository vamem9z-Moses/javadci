package main.java.com.github.vamem9z.dci.usecases.results.products;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public abstract class ProductResult extends UseCaseResult {

	public ProductResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}

}
