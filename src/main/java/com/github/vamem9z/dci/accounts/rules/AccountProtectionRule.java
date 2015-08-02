package com.github.vamem9z.dci.accounts.rules;

import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;

public final class AccountProtectionRule implements Rule {

	public AccountProtectionRule() {}
	
	@Override
	public AbstractResult action(UseCase ctx) {
		if (ctx instanceof AccountWithdrawUseCase) {
			
		}
		return new Successful();
	}
}