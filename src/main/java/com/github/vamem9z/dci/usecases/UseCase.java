package main.java.com.github.vamem9z.dci.usecases;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.rules.Rule;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.general.Successful;

public interface UseCase {
	
	default Stream<UseCaseResult> applyRules(ArrayList<Rule> rules) {
		return rules.stream().map(r->r.action(this));
	}
	
	default Stream<UseCaseResult> execute(UseCase ctx, Function<UseCase, 
			Stream<UseCaseResult>> roleAction, ArrayList<Rule> rules) {
		
		ArrayList<UseCaseResult> rulesResults = this.applyRules(rules)
				.collect(Collectors.toCollection(ArrayList::new));

		if(rulesResults.stream().allMatch(r -> r instanceof Successful)) {
			return roleAction.apply(ctx);
		}
		return rulesResults.stream().filter(r -> !(r instanceof Successful));
	}
	
	Stream<UseCaseResult> execute();
}
