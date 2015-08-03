package com.github.vamem9z.dci.core.roles;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.results.Result;

public interface Role {
	default Stream<Result> returnResults(Result cr) {
		ArrayList<Result> results = new ArrayList<Result>();
		results.add(cr);
		return results.stream();
	}
}
