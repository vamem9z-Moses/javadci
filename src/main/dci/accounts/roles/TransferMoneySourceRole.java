package main.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.accounts.contexts.PayBillsContext;
import main.dci.accounts.contexts.TransferMoneyContext;
import main.dci.contexts.ContextResult;

public interface TransferMoneySourceRole extends BasicAccountRole {	
	
	default Stream<ContextResult> transfer(TransferMoneyContext ctx) {
		
		String withDrawMsg = String.format("Transfer Out %d to Transfer %d", 
				ctx.getSourceAccount().getAccountInfo().getAccountID(),
				ctx.getDestAccount().getAccountInfo().getAccountID());
		
		String depositMsg = String.format("Transfer Out %d to Transfer %d", 
				ctx.getDestAccount().getAccountInfo().getAccountID(),
				ctx.getSourceAccount().getAccountInfo().getAccountID());
		
		AccountWithDrawContext accWithCtx  = new AccountWithDrawContext(
				(AccountRole)ctx.getSourceAccount(), ctx.getAmount(), withDrawMsg);
		accWithCtx.execute();
				
		AccountDepositContext accDepCtx = new AccountDepositContext(
				ctx.getDestAccount(), ctx.getAmount(), depositMsg);
		accDepCtx.execute();
		
		return returnResults(ContextResult.SUCCESS);
	}
	
	default Stream<ContextResult> payBill(TransferMoneySourceRole source, 
			AccountRole creditor) {
		TransferMoneyContext tmctx = new TransferMoneyContext(
				source, creditor, creditor.getBalance());	
		return tmctx.execute();
	}
	
	default Stream<ContextResult> payBills(PayBillsContext ctx) {
		
		ArrayList<ContextResult> errors = ctx.getCreditors().stream()
			.map(creditor ->  payBill(ctx.getSourceAccount(), creditor))
			.flatMap(x ->x).collect(Collectors.toCollection(ArrayList::new));
		return errors.stream();
	}
}	
	