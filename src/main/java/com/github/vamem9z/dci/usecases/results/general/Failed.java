package main.java.com.github.vamem9z.dci.usecases.results.general;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public final class Failed extends GeneralResult {
	public Failed() {
		super("Failed", UseCaseResultTypes.FAILURE);
	}
}
