package main.java.com.github.vamem9z.dci.core.rules;

import main.java.com.github.vamem9z.dci.core.usecases.UseCase;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

@FunctionalInterface
public interface Rule {
	UseCaseResult action(UseCase ctx);
}
