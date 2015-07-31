package com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.core.rules.Rule;
import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import com.github.vamem9z.dci.core.usecases.results.general.Successful;

@NoArgsConstructor
public final class AccountProtectionRule implements Rule {
	@Override
	public UseCaseResult action(UseCase ctx) {
		if (ctx instanceof AccountWithdrawUseCase) {
			
		}
		return new Successful();
	}
}