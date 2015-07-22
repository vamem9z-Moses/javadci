package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.contexts.BalanceChangerContexter;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.contexts.results.WrongContext;
import main.java.com.github.vamem9z.dci.contexts.results.accounts.NegativeAmountNotAllowed;
import main.java.com.github.vamem9z.dci.rules.Ruler;

@NoArgsConstructor
public class NoNegativeAmountsRule implements Ruler {

	@Override
	public ContextResult action(Contexter ctx) {
		try {
			return amountLessThanZero(((BalanceChangerContexter) ctx).transactionAmount());
		}
		catch(ClassCastException e)
		{
			return new WrongContext();
		}
	}
	
	private ContextResult amountLessThanZero(double amount) {
		if(amount >= 0) {
			return new Success();
		}
		return new NegativeAmountNotAllowed();
	}
}