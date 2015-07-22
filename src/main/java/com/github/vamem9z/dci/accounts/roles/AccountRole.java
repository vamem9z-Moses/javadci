package main.java.com.github.vamem9z.dci.accounts.roles;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.domains.accounts.Account;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.roles.Role;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface AccountRole extends Role, Account {
	default Stream<UseCaseResult> deposit(AccountDepositUseCase ctx) {
		ctx.recordTransaction(AccountActions.DEPOSIT);
		
		return returnResults(new Success());	
	}
	
	default Stream<UseCaseResult> withDraw(AccountWithdrawUseCase ctx) {
		ctx.recordTransaction(AccountActions.WITHDRAWAL);
		
		return returnResults(new Success());
	}
}