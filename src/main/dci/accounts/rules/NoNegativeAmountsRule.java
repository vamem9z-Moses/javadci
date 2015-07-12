package main.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;
import main.dci.rules.Ruler;

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
