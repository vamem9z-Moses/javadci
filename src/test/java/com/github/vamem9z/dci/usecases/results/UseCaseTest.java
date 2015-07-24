package test.java.com.github.vamem9z.dci.usecases.results;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface UseCaseTest {
	default ArrayList<UseCaseResult> runContext(UseCase ctx) {
		return ctx.execute().collect(Collectors.toCollection(ArrayList::new));
	}
}
