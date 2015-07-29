package main.java.com.github.vamem9z.dci.core.data.models;

import main.java.com.github.vamem9z.dci.core.data.daos.Dao;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

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
	 * @param dao - dao object to use to save the model
	 * @param simpleClassName - simple String representation of the 
	 * @return a UseCaseResult type from a dao save method
	 */
	UseCaseResult save(final Dao dao, final String simpleClassName);
	
	/**
	 * Utility function to check to see if dao is of the same class as the name passed in
	 * <p>
	 * @param dao - dao object to check
	 * @param simpleClassName - expected simple name of the dao object
	 * @return true if dao simpleName equals simpleClassName
	 */
	default boolean isCorrectDao(final Dao dao, final String simpleClassName) {
		if (dao.getClass().getSimpleName() == simpleClassName) {
			return true;
		}
		return false;
	}
}
