package com.github.vamem9z.dci.core.domains.results.general;

import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public abstract class GeneralResult extends AbstractResult {
	public GeneralResult(String name, ResultTypes type) {
		super(name, type);
	}
}
