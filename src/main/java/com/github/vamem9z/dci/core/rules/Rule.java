package com.github.vamem9z.dci.core.rules;

import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.usecases.UseCase;

@FunctionalInterface
public interface Rule {
	Result action(UseCase ctx);
}
