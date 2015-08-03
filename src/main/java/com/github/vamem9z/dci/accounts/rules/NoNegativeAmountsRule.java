package com.github.vamem9z.dci.accounts.rules;

import com.github.vamem9z.dci.accounts.usecases.ChangeBalanceUseCase;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.accounts.NegativeAmountNotAllowed;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.domains.results.general.WrongContext;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;

public class NoNegativeAmountsRule implements Rule {
	
	public NoNegativeAmountsRule() {}

	@Override
	public final Result action(UseCase ctx) {
		try {
			return amountLessThanZero(((ChangeBalanceUseCase) ctx).transactionAmount());
		}
		catch(ClassCastException e)
		{
			return new WrongContext();
		}
	}
	
	private Result amountLessThanZero(double amount) {
		if(amount >= 0) {
			return new Successful();
		}
		return new NegativeAmountNotAllowed();
	}
}