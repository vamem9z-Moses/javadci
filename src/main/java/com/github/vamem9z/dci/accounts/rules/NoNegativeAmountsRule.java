package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.usecases.ChangeBalanceUseCase;
import main.java.com.github.vamem9z.dci.rules.Rule;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.accounts.NegativeAmountNotAllowed;
import main.java.com.github.vamem9z.dci.usecases.results.general.Successful;
import main.java.com.github.vamem9z.dci.usecases.results.general.WrongContext;

@NoArgsConstructor
public class NoNegativeAmountsRule implements Rule {

	@Override
	public final UseCaseResult action(UseCase ctx) {
		try {
			return amountLessThanZero(((ChangeBalanceUseCase) ctx).transactionAmount());
		}
		catch(ClassCastException e)
		{
			return new WrongContext();
		}
	}
	
	private UseCaseResult amountLessThanZero(double amount) {
		if(amount >= 0) {
			return new Successful();
		}
		return new NegativeAmountNotAllowed();
	}
}