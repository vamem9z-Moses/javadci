package com.github.vamem9z.dci.core.domains.results.general;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class WrongContext extends  GeneralResult {
	public WrongContext() {
		super("Wrong Context", ResultTypes.FAILURE);
	}
}
