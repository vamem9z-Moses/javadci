package com.github.vamem9z.dci.core.domains.results.products;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public abstract class ProductResult extends AbstractResult {

	public ProductResult(String name, ResultTypes type) {
		super(name, type);
	}

}
