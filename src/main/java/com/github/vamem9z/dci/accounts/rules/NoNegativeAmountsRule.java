package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.rules.Ruler;

@NoArgsConstructor
public class NoNegativeAmountsRule implements Ruler {

	@Override
	public ContextResult action(Contexter ctx) {
		if(ctx instanceof AccountDepositContext) { 
			return amountLessThanZero(((AccountDepositContext) ctx).getAmount());
		}
		if(ctx instanceof AccountWithDrawContext) {
			return amountLessThanZero(((AccountWithDrawContext) ctx).getAmount());
		}
		return ContextResult.SUCCESS;
	}
	
	private ContextResult amountLessThanZero(double amount) {
		if(amount >= 0) {
			return ContextResult.SUCCESS;
		}
		return ContextResult.FAILURE;
	}
}
