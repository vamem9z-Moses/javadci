package com.github.vamem9z.dci.core.data.models;

import com.github.vamem9z.dci.core.domains.results.Result;

public interface Model {
	/**
	 * Provide the unique identifier of the object
	 * <p>
	 * @return an int that represents the unique identifier of the object
	 */
	int id();
	/**
	 * Uses dao injected by the constructor to save the model
	 * <p>
	 * @return a UseCaseResult type from a dao save method
	 */
	Result save();
}
