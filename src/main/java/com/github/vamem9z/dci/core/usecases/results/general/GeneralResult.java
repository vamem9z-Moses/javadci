package main.java.com.github.vamem9z.dci.core.usecases.results.general;

import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public abstract class GeneralResult extends UseCaseResult {
	public GeneralResult(String name, UseCaseResultTypes type) {
		super(name, type);
	}
}