package com.github.vamem9z.dci.core.domains.results.general;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class WrongDao extends  GeneralResult {
	public WrongDao() {
		super("Wrong Dao", ResultTypes.FAILURE);
	}
}
