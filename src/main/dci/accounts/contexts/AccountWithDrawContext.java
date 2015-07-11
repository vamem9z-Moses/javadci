package main.dci.accounts.contexts;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.rules.AccountProtectionRule;
import main.dci.contexts.Contexter;
import main.dci.contexts.ContextResult;
import main.dci.rules.Ruler;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
public class AccountWithDrawContext implements Contexter {
	@Getter private AccountRole account;
	@Getter private double amount;
	@Getter private String message;
	private ArrayList<Ruler> rules;
	
	public AccountWithDrawContext(AccountRole account, double amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.rules = new ArrayList<Ruler>();
		rules.add(new AccountProtectionRule());
	}
	
	public ArrayList<ContextResult>execute(){
		return execute(this, ctx -> this.account.withDraw((AccountWithDrawContext)ctx), this.rules);
	}
}

