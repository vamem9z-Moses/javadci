package main.java.com.github.vamem9z.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.PayBillsContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.TransferMoneyContext;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.Success;
import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;
import main.java.com.github.vamem9z.dci.roles.Roler;

public interface TransferMoneySourceRole extends Roler, BasicAccount {	
	
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
		
		return returnResults(new Success());
	}
	
	default Stream<ContextResult> payBill(TransferMoneySourceRole source, 
			AccountRole creditor) {
		TransferMoneyContext tmctx = new TransferMoneyContext(
				source, creditor, creditor.calcBalance());	
		return tmctx.execute();
	}
	
	default Stream<ContextResult> payBills(PayBillsContext ctx) {
		
		ArrayList<ContextResult> errors = ctx.getCreditors().stream()
			.map(creditor ->  payBill(ctx.getSourceAccount(), creditor))
			.flatMap(x ->x).collect(Collectors.toCollection(ArrayList::new));
		return errors.stream();
	}
}	
	