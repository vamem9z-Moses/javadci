package main.java.com.github.vamem9z.dci.domains.accounts.types;

import main.java.com.github.vamem9z.dci.domains.accounts.AssetAccount;

public class CheckingAccount extends AssetAccount {
	public CheckingAccount(String name, int accountID, int userID, 
			double startingBalance) {
		super(name, accountID, userID, startingBalance, AccountTypes.SAVINGSACCOUNT);
	}
}
