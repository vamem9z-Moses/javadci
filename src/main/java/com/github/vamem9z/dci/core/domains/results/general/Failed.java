package com.github.vamem9z.dci.core.domains.results.general;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class Failed extends GeneralResult {
	public Failed() {
		super("Failed", ResultTypes.FAILURE);
	}
}
