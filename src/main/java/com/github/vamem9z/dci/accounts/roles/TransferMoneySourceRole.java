package main.java.com.github.vamem9z.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import main.java.com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import main.java.com.github.vamem9z.dci.accounts.usecases.PayBillUseCase;
import main.java.com.github.vamem9z.dci.accounts.usecases.TransferMoneyUseCase;
import main.java.com.github.vamem9z.dci.domains.accounts.Account;
import main.java.com.github.vamem9z.dci.roles.Role;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

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
	