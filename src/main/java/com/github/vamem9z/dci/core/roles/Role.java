package com.github.vamem9z.dci.core.roles;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

public interface Role {
	default Stream<UseCaseResult> returnResults(UseCaseResult cr) {
		ArrayList<UseCaseResult> results = new ArrayList<UseCaseResult>();
		results.add(cr);
		return results.stream();
	}
}
