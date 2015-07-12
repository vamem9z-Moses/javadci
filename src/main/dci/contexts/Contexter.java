package main.dci.contexts;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.dci.rules.Ruler;

public interface Contexter {
	
	default Stream<ContextResult> applyRules(ArrayList<Ruler> rules) {
		return rules.stream().map(r->r.action(this));
	}
	
	default Stream<ContextResult> execute(Contexter ctx, Function<Contexter, 
			Stream<ContextResult>> roleAction, ArrayList<Ruler> rules) {
		
		ArrayList<ContextResult> rulesResults = this.applyRules(rules)
				.collect(Collectors.toCollection(ArrayList::new));

		if(rulesResults.stream().allMatch(r -> r == ContextResult.SUCCESS)) {
			return roleAction.apply(ctx);
		}
		return rulesResults.stream().filter(r -> r != ContextResult.SUCCESS);
	}
	
	Stream<ContextResult> execute();
}
