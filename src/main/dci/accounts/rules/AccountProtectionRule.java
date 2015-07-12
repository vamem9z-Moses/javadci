package main.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;
import main.dci.rules.Ruler;

@NoArgsConstructor
public class AccountProtectionRule implements Ruler {
	@Override
	public ContextResult action(Contexter ctx) {
		if (ctx instanceof AccountWithDrawContext) {
			
		}
		return ContextResult.SUCCESS;
	}
}