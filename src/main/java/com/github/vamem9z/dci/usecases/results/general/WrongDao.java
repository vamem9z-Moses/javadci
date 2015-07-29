package main.java.com.github.vamem9z.dci.usecases.results.general;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public final class WrongDao extends  GeneralResult {
	public WrongDao() {
		super("Wrong Dao", UseCaseResultTypes.FAILURE);
	}
}
