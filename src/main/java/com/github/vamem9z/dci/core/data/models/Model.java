package com.github.vamem9z.dci.core.data.models;

import com.github.vamem9z.dci.core.data.daos.Dao;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

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
	UseCaseResult save();
	
	/**
	 * Uses parameter injected by the save method to save the model
	 * <p>
	 * @param dao dao object to use to save the model
	 * @param objClassName - simple String representation of the 
	 * @return a UseCaseResult type from a dao save method
	 */
	UseCaseResult save(final Dao dao, final Class<Dao> objClassName);
	
	/**
	 * Utility function to check to see if dao is of the same class as the name passed in
	 * <p>
	 * @param dao dao object to check
	 * @param objClassName expected class name of the dao object
	 * @return true if dao simpleName equals simpleClassName
	 */
	default boolean isCorrectDao(final Dao dao, final Class<Dao> objClassName) {
		if (dao.getClass() == objClassName) {
			return true;
		}
		return false;
	}
}
