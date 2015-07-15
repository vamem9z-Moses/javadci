package main.java.com.github.vamem9z.dci.accounts.roles;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;
import main.java.com.github.vamem9z.dci.roles.Roler;

public interface AccountRole extends Roler, BasicAccount {
	
	default Stream<ContextResult> deposit(AccountDepositContext ctx) {
		ctx.getAccount().recordTransaction(ctx.getAmount(), ctx.getMessage(), 
				AccountActions.DEPOSIT);
		
		return returnResults(ContextResult.SUCCESS);
		
	}
	
	default Stream<ContextResult> withDraw(AccountWithDrawContext ctx) {
		ctx.getAccount().recordTransaction(ctx.getAmount(), 
				ctx.getMessage(), AccountActions.WITHDRAWAL);
		
		return returnResults(ContextResult.SUCCESS);
	}
}
