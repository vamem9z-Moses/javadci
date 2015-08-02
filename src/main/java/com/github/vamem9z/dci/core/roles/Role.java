package com.github.vamem9z.dci.core.roles;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;

public interface Role {
	default Stream<AbstractResult> returnResults(AbstractResult cr) {
		ArrayList<AbstractResult> results = new ArrayList<AbstractResult>();
		results.add(cr);
		return results.stream();
	}
}
