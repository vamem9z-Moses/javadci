package main.java.com.github.vamem9z.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.contexts.AccountDepositContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.AccountWithDrawContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.PayBillsContext;
import main.java.com.github.vamem9z.dci.accounts.contexts.TransferMoneyContext;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.BasicAccount;
import main.java.com.github.vamem9z.dci.roles.Roler;

public interface TransferMoneySourceRole extends Roler, BasicAccount {	
	
	default Stream<ContextResult> transfer(TransferMoneyContext ctx) {
		
		AccountWithDrawContext accWithCtx = ctx.createWithDrawCtx();
		Stream<ContextResult> withResult = accWithCtx.execute();
		
		AccountDepositContext accDepCtx = ctx.createDepCtx();
		Stream<ContextResult> depResult = accDepCtx.execute();
		
		return Stream.concat(withResult, depResult);
	}
	
	default Stream<ContextResult> payBill(TransferMoneySourceRole source, 
			AccountRole creditor) {
		TransferMoneyContext tmctx = new TransferMoneyContext(
				source, creditor, creditor.calcBalance());	
		return tmctx.execute();
	}
	
	default Stream<ContextResult> payBills(PayBillsContext ctx) {
		
		ArrayList<ContextResult> errors = ctx.creditors().stream()
			.map(creditor ->  payBill(ctx.sourceAccount(), creditor))
			.flatMap(x ->x).collect(Collectors.toCollection(ArrayList::new));
		return errors.stream();
	}
}	
	