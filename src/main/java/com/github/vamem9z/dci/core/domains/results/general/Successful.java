package com.github.vamem9z.dci.core.domains.results.general;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class Successful extends GeneralResult {
	public Successful() {
		super("Successful", ResultTypes.SUCCESS);
	}
}
