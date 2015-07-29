package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.core.rules.Rule;
import main.java.com.github.vamem9z.dci.core.usecases.UseCase;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.core.usecases.results.general.Successful;

@NoArgsConstructor
public final class AccountProtectionRule implements Rule {
	@Override
	public UseCaseResult action(UseCase ctx) {
		if (ctx instanceof AccountWithdrawUseCase) {
			
		}
		return new Successful();
	}
}