package com.github.vamem9z.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.accounts.usecases.PayBillUseCase;
import com.github.vamem9z.dci.accounts.usecases.TransferMoneyUseCase;
import com.github.vamem9z.dci.core.domains.accounts.Account;
import com.github.vamem9z.dci.core.roles.Role;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

public interface TransferMoneySourceRole extends Role, Account {	
	
	default Stream<UseCaseResult> transfer(TransferMoneyUseCase ctx) {
		
		AccountWithdrawUseCase accWithCtx = ctx.createWithDrawCtx();
		Stream<UseCaseResult> withResult = accWithCtx.execute();
		
		AccountDepositUseCase accDepCtx = ctx.createDepCtx();
		Stream<UseCaseResult> depResult = accDepCtx.execute();
		
		return Stream.concat(withResult, depResult);
	}
	
	default Stream<UseCaseResult> payBill(TransferMoneySourceRole source, 
			AccountRole creditor) {
		TransferMoneyUseCase tmctx = new TransferMoneyUseCase(
				source, creditor, creditor.calcBalance());	
		return tmctx.execute();
	}
	
	default Stream<UseCaseResult> payBills(PayBillUseCase ctx) {
		
		ArrayList<UseCaseResult> errors = ctx.creditors().stream()
			.map(creditor ->  payBill(ctx.sourceAccount(), creditor))
			.flatMap(x ->x).collect(Collectors.toCollection(ArrayList::new));
		return errors.stream();
	}
}	
	