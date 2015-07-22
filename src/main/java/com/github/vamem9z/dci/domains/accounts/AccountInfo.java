package main.java.com.github.vamem9z.dci.domains.accounts;


import lombok.AllArgsConstructor;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public class AccountInfo {
	private String name;
	private int accountId;
	private int userId;
	private final double startingBalance;
	private AccountTypes productCategory;
	
	public final String printAccountID() {
		return String.valueOf(this.accountId);
	}
	
	public final int accountId() {
		return this.accountId;
	}
	
	public final double startingBalance() {
		return this.startingBalance;
	}
}
	
