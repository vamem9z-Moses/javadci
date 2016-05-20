package com.github.vamem9z.dci.accounts.rules;


import com.github.vamem9z.dci.accounts.usecases.ChangeBalanceUseCase;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.accounts.InsufficientBalance;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.domains.results.general.WrongContext;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;

public final class AccountProtectionRule implements Rule {

	public AccountProtectionRule() {}

	@Override
	public final Result action(UseCase ctx) {
		try {
			ChangeBalanceUseCase useCase = (ChangeBalanceUseCase) ctx;
				return hasSufficientBalance(useCase.currentBalance(), useCase.transactionAmount());
		}
		catch(ClassCastException e)
		{
			return new WrongContext();
		}
	}

	private Result hasSufficientBalance(double balance, double amount){
		if(balance < amount ){
			return new InsufficientBalance();
		}
		return new Successful();
	}
}