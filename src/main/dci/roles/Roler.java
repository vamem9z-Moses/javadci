package main.dci.roles;

import java.util.ArrayList;
import java.util.stream.Stream;

import main.dci.contexts.ContextResult;

public interface Roler {
	default Stream<ContextResult> returnResults(ContextResult cr) {
		ArrayList<ContextResult> results = new ArrayList<ContextResult>();
		results.add(cr);
		return results.stream();
	}
}
