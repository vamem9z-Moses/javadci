package com.github.vamem9z.dci.core.rules;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.usecases.UseCase;

@FunctionalInterface
public interface Rule {
	AbstractResult action(UseCase ctx);
}
