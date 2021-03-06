package com.github.vamem9z.dci.accounts.roles;

import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.core.domains.accounts.Account;
import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.general.Successful;
import com.github.vamem9z.dci.core.roles.Role;

public interface AccountRole extends Role, Account {
	default Stream<Result> deposit(AccountDepositUseCase ctx) {
		ctx.recordTransaction(AccountActions.DEPOSIT);
		
		return returnResults(new Successful());	
	}
	
	default Stream<Result> withDraw(AccountWithdrawUseCase ctx) {
		ctx.recordTransaction(AccountActions.WITHDRAWAL);
		
		return returnResults(new Successful());
	}
}