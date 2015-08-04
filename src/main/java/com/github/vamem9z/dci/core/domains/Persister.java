package com.github.vamem9z.dci.core.domains;

import com.github.vamem9z.dci.core.data.daos.Dao;
import com.github.vamem9z.dci.core.data.models.Model;
import com.github.vamem9z.dci.core.domains.results.Result;

public interface Persister<T extends Model> {
	/**
	 * Gives domain objects the ability to persist and retrieve themselves from the data store.
	 * <p>
	 * @return the model for this object cast as a Model
	 */
	T createModel();
	
	/**
	 * Saves the model (current state) version of the domain object.
	 * <p>
	 * @return the Saved Domain Name UseCaseResult, or Failed UseCaseResult if save operation is aborted.
	 */
	default Result save() {
		T model = createModel();
		return model.save();
	}
	
	/**
	 * Saves the model (current state) version of the domain object with a specific dao.
	 * @param <U>
	 * @return the Saved Domain Name UseCaseResult, or Failed UseCaseResult if the save operation is aborted.
	 */
	default Result save(final Dao dao, final Class<Dao> objClassName) {
		T model = createModel();
		return model.save(dao, objClassName);
	}
}
