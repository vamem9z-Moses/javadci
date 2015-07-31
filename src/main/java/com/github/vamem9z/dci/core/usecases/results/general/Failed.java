package com.github.vamem9z.dci.core.usecases.results.general;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class Failed extends GeneralResult {
	public Failed() {
		super("Failed", UseCaseResultTypes.FAILURE);
	}
}
