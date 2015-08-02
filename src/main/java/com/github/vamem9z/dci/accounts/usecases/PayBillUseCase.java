package com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.github.vamem9z.dci.accounts.roles.AccountRole;
import com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.usecases.UseCase;

public final class PayBillUseCase implements UseCase {
	private final TransferMoneySourceRole sourceAccount;
	private final ArrayList<AccountRole> creditors;

	public PayBillUseCase(TransferMoneySourceRole sourceAccount, 
			ArrayList<AccountRole> creditors) {
		this.sourceAccount = sourceAccount;
		this.creditors = creditors;
	}
	
	@Override
	public Stream<AbstractResult> execute() {
		return this.sourceAccount.payBills(this);
	}
	
	public TransferMoneySourceRole sourceAccount() {
		return this.sourceAccount;
	}
	
	public ArrayList<AccountRole> creditors() {
		return this.creditors;
	}
}