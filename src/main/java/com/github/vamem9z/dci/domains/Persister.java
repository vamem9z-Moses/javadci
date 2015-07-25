package main.java.com.github.vamem9z.dci.domains;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface Persister {
	/**
	 * Gives domain objects the ability to persist and retrieve themselves from the data store.
	 */
	Model createModel();
	
	default UseCaseResult save() {
		/**
		 * Saves the model (current state) version of the domain object.
		 * <p>
		 * @return the Saved<DomainName> UseCaseResult, or Failed UseCaseResult if save operation aborted.
		 */
		Model model = createModel();
		return model.save();
	}
}
