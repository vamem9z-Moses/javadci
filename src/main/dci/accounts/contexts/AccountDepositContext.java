package main.dci.accounts.contexts;

import java.util.stream.Stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
public class AccountDepositContext implements Contexter {
	@Getter private AccountRole account;
	@Getter private double amount;
	@Getter private String message;
	
	public AccountDepositContext(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
	}
	
	public Stream<ContextResult> execute() {
		return execute(this, (Contexter ctx) -> this.account.deposit((AccountDepositContext) ctx));
	}
}