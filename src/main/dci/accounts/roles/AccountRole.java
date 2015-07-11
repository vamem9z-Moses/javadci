package main.dci.accounts.roles;

import java.util.stream.Stream;

import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.contexts.ContextResult;
import main.dci.domains.AccountDomain.TRANSACTIONTYPES;

public interface AccountRole extends BasicAccountRole {
	
	default Stream<ContextResult> deposit(AccountDepositContext ctx) {
		TRANSACTIONTYPES transType = null;
		
		switch (ctx.getAccount().getAccountInfo().getAccountType()) {
		case ASSETACCOUNT:
			transType = TRANSACTIONTYPES.CREDIT;
			break;
		case LIABILITYACCOUNT:
			transType = TRANSACTIONTYPES.DEBIT;
			break;
		}
		ctx.getAccount().recordTransaction(ctx.getAmount(), ctx.getMessage(), 
				transType);
		
		return returnResults(ContextResult.SUCCESS);
		
	}
	
	default Stream<ContextResult> withDraw(AccountWithDrawContext ctx) {
		TRANSACTIONTYPES transType = null;
		
		switch (ctx.getAccount().getAccountInfo().getAccountType()) {
		case ASSETACCOUNT:
			transType = TRANSACTIONTYPES.DEBIT;
			break;
		case LIABILITYACCOUNT:
			transType = TRANSACTIONTYPES.CREDIT;
			break;
		}
		ctx.getAccount().recordTransaction(ctx.getAmount(), 
				ctx.getMessage(), transType);
		
		return returnResults(ContextResult.SUCCESS);
	}
}
