package com.github.vamem9z.dci.core.usecases;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.usecases.UseCase;

public interface UseCaseTest {
	default ArrayList<AbstractResult> runContext(UseCase ctx) {
		return ctx.execute().collect(Collectors.toCollection(ArrayList::new));
	}
}
