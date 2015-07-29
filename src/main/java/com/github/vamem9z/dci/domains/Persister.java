package main.java.com.github.vamem9z.dci.domains;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.data.daos.Dao;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface Persister {
	/**
	 * Gives domain objects the ability to persist and retrieve themselves from the data store.
	 * <p>
	 * @return the model for this object cast as a Model
	 */
	Model createModel();
	
	/**
	 * Saves the model (current state) version of the domain object.
	 * <p>
	 * @return the Saved Domain Name UseCaseResult, or Failed UseCaseResult if save operation is aborted.
	 */
	default UseCaseResult save() {
		Model model = createModel();
		return model.save();
	}
	
	/**
	 * Saves the model (current state) version of the domain object with a specific dao.
	 * @return the Saved Domain Name UseCaseResult, or Failed UseCaseResult if the save operation is aborted.
	 */
	default UseCaseResult save(final Dao dao, final String simpleClassName) {
		Model model = createModel();
		return model.save(dao, simpleClassName);
	}
}
