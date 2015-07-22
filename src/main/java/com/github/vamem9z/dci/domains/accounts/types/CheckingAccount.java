package main.java.com.github.vamem9z.dci.domains.accounts.types;

import main.java.com.github.vamem9z.dci.domains.accounts.AbstractAssetAccount;

public final class CheckingAccount extends AbstractAssetAccount {
	public CheckingAccount(String name, int accountID, int userID, 
			double startingBalance) {
		super(name, accountID, userID, startingBalance, AccountTypes.SAVINGSACCOUNT);
	}
}
