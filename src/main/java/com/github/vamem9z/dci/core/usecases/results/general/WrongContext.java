package main.java.com.github.vamem9z.dci.core.usecases.results.general;

import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class WrongContext extends  GeneralResult {
	public WrongContext() {
		super("Wrong Context", UseCaseResultTypes.FAILURE);
	}
}
