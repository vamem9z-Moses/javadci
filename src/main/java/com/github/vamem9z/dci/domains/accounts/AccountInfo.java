package main.java.com.github.vamem9z.dci.domains.accounts;


import lombok.AllArgsConstructor;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public final class AccountInfo {
	private String name;
	private int accountId;
	private int userId;
	private final double startingBalance;
	private AccountTypes productCategory;
	
	public String printAccountID() {
		return String.valueOf(this.accountId);
	}
	
	public int accountId() {
		return this.accountId;
	}
	
	public double startingBalance() {
		return this.startingBalance;
	}
}
	
