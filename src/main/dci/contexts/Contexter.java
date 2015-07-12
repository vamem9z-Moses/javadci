package main.dci.contexts;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.dci.rules.Ruler;

public interface Contexter {

	static boolean isSuccess(Stream<ContextResult> results) {
		if(results.allMatch(r -> r == ContextResult.SUCCESS))
				return true;
		return false;	
	}
	
	static Stream<ContextResult> getErrors(Stream<ContextResult> results) {
		return results.filter(r -> r != ContextResult.SUCCESS);
	}
	
	default Stream<ContextResult> applyRules(ArrayList<Ruler> rules) {
		return rules.stream().map(r->r.action(this));
	}
	
	default Stream<ContextResult> execute(Contexter ctx, Function<Contexter, Stream<ContextResult>> roleAction) {
		return roleAction.apply(ctx);

	}
	
	default Stream<ContextResult> execute(Contexter ctx, Function<Contexter, Stream<ContextResult>> roleAction, ArrayList<Ruler> rules) {
		ArrayList<ContextResult> results = this.applyRules(rules).collect(Collectors.toCollection(ArrayList::new));

		if(isSuccess(results.stream())) {
			return this.execute(ctx, roleAction);
		}
		return getErrors(results.stream());
	}
	
	Stream<ContextResult> execute();
}
