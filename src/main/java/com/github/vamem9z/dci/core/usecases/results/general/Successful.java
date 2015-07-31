package com.github.vamem9z.dci.core.usecases.results.general;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class Successful extends GeneralResult {
	public Successful() {
		super("Successful", UseCaseResultTypes.SUCCESS);
	}
}
