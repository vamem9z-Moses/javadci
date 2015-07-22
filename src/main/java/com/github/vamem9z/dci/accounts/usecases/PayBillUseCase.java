package main.java.com.github.vamem9z.dci.accounts.usecases;

import java.util.ArrayList;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public final class PayBillUseCase implements UseCase {
	private TransferMoneySourceRole sourceAccount;
	private ArrayList<AccountRole> creditors;

	public PayBillUseCase(TransferMoneySourceRole sourceAccount, 
			ArrayList<AccountRole> creditors) {
		this.sourceAccount = sourceAccount;
		this.creditors = creditors;
	}
	
	@Override
	public Stream<UseCaseResult> execute() {
		return this.sourceAccount.payBills(this);
	}
	
	public TransferMoneySourceRole sourceAccount() {
		return this.sourceAccount;
	}
	
	public ArrayList<AccountRole> creditors() {
		return this.creditors;
	}
}