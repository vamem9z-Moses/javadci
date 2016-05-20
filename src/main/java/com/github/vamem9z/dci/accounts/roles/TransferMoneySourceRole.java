package com.github.vamem9z.dci.accounts.roles;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.usecases.AccountDepositUseCase;
import com.github.vamem9z.dci.accounts.usecases.AccountWithdrawUseCase;
import com.github.vamem9z.dci.accounts.usecases.PayBillUseCase;
import com.github.vamem9z.dci.accounts.usecases.TransferMoneyUseCase;
import com.github.vamem9z.dci.core.domains.accounts.Account;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.roles.Role;

public interface TransferMoneySourceRole extends Role, Account, AccountRole {

	default Stream<Result> transfer(TransferMoneyUseCase ctx) {

		AccountWithdrawUseCase accWithCtx = ctx.createWithDrawCtx();
		Stream<Result> withResult = accWithCtx.execute();

		ArrayList<Result> withResults = withResult.collect(Collectors.toCollection(ArrayList::new));

		if(withResults.stream().anyMatch(r -> r.isFailure())) {
			return withResults.stream();
		}

		AccountDepositUseCase accDepCtx = ctx.createDepCtx();
		Stream<Result> depResult = accDepCtx.execute();

		return depResult;
	}

	default Stream<Result> payBill(TransferMoneySourceRole source,
			AccountRole creditor) {
		TransferMoneyUseCase tmctx = new TransferMoneyUseCase(
				source, creditor, creditor.calcBalance());
		return tmctx.execute();
	}

	default Stream<Result> payBills(PayBillUseCase ctx) {

		ArrayList<Result> errors = ctx.creditors().stream()
			.map(creditor ->  payBill(ctx.sourceAccount(), creditor))
			.flatMap(x ->x).collect(Collectors.toCollection(ArrayList::new));
		return errors.stream();
	}
}
