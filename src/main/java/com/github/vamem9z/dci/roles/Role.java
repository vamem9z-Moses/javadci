package main.java.com.github.vamem9z.dci.roles;

import java.util.ArrayList;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface Role {
	default Stream<UseCaseResult> returnResults(UseCaseResult cr) {
		ArrayList<UseCaseResult> results = new ArrayList<UseCaseResult>();
		results.add(cr);
		return results.stream();
	}
}
