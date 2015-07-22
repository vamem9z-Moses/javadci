package main.java.com.github.vamem9z.dci.accounts.rules;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.rules.Rule;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

@NoArgsConstructor
public final class AccountProtectionRule implements Rule {
	@Override
	public UseCaseResult action(UseCase ctx) {
		if (ctx instanceof AccountWithdrawUseCase) {
			
		}
		return new Success();
	}
}