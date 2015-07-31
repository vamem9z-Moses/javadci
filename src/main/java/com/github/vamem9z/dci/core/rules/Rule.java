package com.github.vamem9z.dci.core.rules;

import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

@FunctionalInterface
public interface Rule {
	UseCaseResult action(UseCase ctx);
}
