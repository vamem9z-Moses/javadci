package com.github.vamem9z.dci.core.usecases.results.products;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public abstract class ProductResult extends UseCaseResult {

	public ProductResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}

}
