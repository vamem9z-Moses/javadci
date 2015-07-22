package main.java.com.github.vamem9z.dci.rules;

import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface Rule {
	UseCaseResult action(UseCase ctx);
}
