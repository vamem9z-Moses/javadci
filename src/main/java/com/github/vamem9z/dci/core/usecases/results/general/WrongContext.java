package com.github.vamem9z.dci.core.usecases.results.general;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class WrongContext extends  GeneralResult {
	public WrongContext() {
		super("Wrong Context", UseCaseResultTypes.FAILURE);
	}
}
