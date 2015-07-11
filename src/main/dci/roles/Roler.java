package main.dci.roles;

import java.util.ArrayList;

import main.dci.contexts.ContextResult;

public interface Roler {
	default ArrayList<ContextResult> returnResults(ContextResult cr) {
		ArrayList<ContextResult> results = new ArrayList<ContextResult>();
		results.add(cr);
		return results;
	}
}
