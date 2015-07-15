package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.rules.Ruler;

@NoArgsConstructor
public class AccountProtectionRule implements Ruler {
	@Override
	public ContextResult action(Contexter ctx) {
		if (ctx instanceof AccountWithDrawContext) {
			
		}
		return new Success();
	}
}