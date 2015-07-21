package main.java.com.github.vamem9z.dci.domains.accounts;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public class AccountInfo {
	@Getter private String name;
	@Getter private int accountID;
	@Getter private int userID;
	@Getter private double startingBalance;
	private AccountTypes productCategory;
	
	public String printAccountID() {
		return String.valueOf(accountID);
	}
}
	
