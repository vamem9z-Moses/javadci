package main.dci.accounts.roles;

import java.util.stream.Stream;

import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.contexts.ContextResult;
import main.dci.domains.accounts.AccountActions;
import main.dci.domains.accounts.BasicAccount;
import main.dci.roles.Roler;

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
