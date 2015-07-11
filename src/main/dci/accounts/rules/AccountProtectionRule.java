package main.dci.accounts.rules;

import lombok.Data;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.contexts.Contexter;
import main.dci.contexts.ContextResult;
import main.dci.rules.Ruler;

@Data
public class AccountProtectionRule implements Ruler {
	public ContextResult action(Contexter ctx) {
		if (ctx instanceof AccountWithDrawContext) {
			
		}
		return ContextResult.SUCCESS;
	}
}