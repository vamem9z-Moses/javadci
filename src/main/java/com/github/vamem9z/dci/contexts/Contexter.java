package main.java.com.github.vamem9z.dci.contexts;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.rules.Ruler;

public interface Contexter {
	
	default Stream<ContextResult> applyRules(ArrayList<Ruler> rules) {
		return rules.stream().map(r->r.action(this));
	}
	
	default Stream<ContextResult> execute(Contexter ctx, Function<Contexter, 
			Stream<ContextResult>> roleAction, ArrayList<Ruler> rules) {
		
		ArrayList<ContextResult> rulesResults = this.applyRules(rules)
				.collect(Collectors.toCollection(ArrayList::new));

		if(rulesResults.stream().allMatch(r -> r instanceof Success)) {
			return roleAction.apply(ctx);
		}
		return rulesResults.stream().filter(r -> !(r instanceof Success));
	}
	
	Stream<ContextResult> execute();
}
