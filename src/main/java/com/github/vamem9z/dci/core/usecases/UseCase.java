package com.github.vamem9z.dci.core.usecases;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.rules.Rule;

public interface UseCase {
	
	default Stream<AbstractResult> applyRules(ArrayList<Rule> rules) {
		return rules.stream().map(r->r.action(this));
	}
	
	default Stream<AbstractResult> execute(UseCase ctx, Function<UseCase, 
			Stream<AbstractResult>> roleAction, ArrayList<Rule> rules) {
		
		ArrayList<AbstractResult> rulesResults = this.applyRules(rules)
				.collect(Collectors.toCollection(ArrayList::new));

		if(rulesResults.stream().allMatch(r -> r instanceof Successful)) {
			return roleAction.apply(ctx);
		}
		return rulesResults.stream().filter(r -> !(r instanceof Successful));
	}
	
	Stream<AbstractResult> execute();
}
