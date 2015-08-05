package com.github.vamem9z.dci.core.domains;

import com.github.vamem9z.dci.core.data.models.Model;
import com.github.vamem9z.dci.core.data.models.ModelBuilder;

public interface Persister<U extends ModelBuilder<? extends Model>> {
	/**
	 * Gives domain objects the ability to persist and retrieve themselves from the data store.
	 * <p>
	 * @return the model for this object cast as a Model
	 */
	 U createModelBuilder();
}
