package main.dci.contexts;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import main.dci.rules.Ruler;

public interface Contexter {

	static boolean isSuccess(ArrayList<ContextResult> results) {
		if(results.stream().allMatch(r -> r == ContextResult.SUCCESS))
				return true;
		return false;	
	}
	
	static ArrayList<ContextResult> getErrors(ArrayList<ContextResult> results) {
		return results.stream().filter(r -> r != ContextResult.SUCCESS).collect(Collectors.toCollection(ArrayList::new));
	}
	
	default ArrayList<ContextResult> applyRules(ArrayList<Ruler> rules) {
		return rules.stream().map(r->r.action(this)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	default ArrayList<ContextResult> execute(Contexter ctx, Function<Contexter, ArrayList<ContextResult>> roleAction) {
		return roleAction.apply(ctx);

	}
	
	default ArrayList<ContextResult> execute(Contexter ctx, Function<Contexter, ArrayList<ContextResult>> roleAction, ArrayList<Ruler> rules) {
		ArrayList<ContextResult> errors = this.applyRules(rules);
		if(isSuccess(errors)) {
			return this.execute(ctx, roleAction);
		}
		return getErrors(errors);
	}
	
	ArrayList<ContextResult> execute();
}
