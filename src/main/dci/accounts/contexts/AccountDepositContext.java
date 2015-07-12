package main.dci.accounts.contexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.rules.NoNegativeAmountsRule;
import main.dci.contexts.ContextResult;
import main.dci.contexts.Contexter;
import main.dci.rules.Ruler;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
public class AccountDepositContext implements Contexter {
	@Getter private AccountRole account;
	@Getter private double amount;
	@Getter private String message;
	@Getter private ArrayList<Ruler> rules;
	
	public AccountDepositContext(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Ruler>(Arrays.asList(new NoNegativeAmountsRule()));
	}
	
	public Stream<ContextResult> execute() {
		return execute(this, (Contexter ctx) -> this.account.deposit((AccountDepositContext) ctx), this.rules);
	}
}