package com.github.vamem9z.dci.core.usecases;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;
import com.github.vamem9z.dci.core.rules.Rule;

public interface UseCase {

	default Stream<Result> applyRules(ArrayList<Rule> rules) {
		return rules.stream().map(r->r.action(this));
	}

	default Stream<Result> execute(UseCase ctx, Function<UseCase,
			Stream<Result>> roleAction, ArrayList<Rule> rules) {

		ArrayList<Result> rulesResults = this.applyRules(rules)
				.collect(Collectors.toCollection(ArrayList::new));

		if(rulesResults.stream().anyMatch(r -> r.resultType() == ResultTypes.FAILURE)) {
			return rulesResults.stream();
		}
		return roleAction.apply(ctx);
	}

	Stream<Result> execute();
}
