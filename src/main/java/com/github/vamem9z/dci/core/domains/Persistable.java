package com.github.vamem9z.dci.core.domains;

import com.github.vamem9z.dci.core.data.models.Model;
import com.github.vamem9z.dci.core.data.models.ModelBuilder;

/**
 * Gives domain objects the ability to persist and retrieve themselves from the data store.
 * <p>
 * @return the ModelBuilder for this object 
 */
public interface Persistable<U extends ModelBuilder<? extends Model>> {
	 U createModelBuilder();
}