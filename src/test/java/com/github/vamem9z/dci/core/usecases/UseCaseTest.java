package com.github.vamem9z.dci.core.usecases;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

public interface UseCaseTest {
	default ArrayList<UseCaseResult> runContext(UseCase ctx) {
		return ctx.execute().collect(Collectors.toCollection(ArrayList::new));
	}
}
