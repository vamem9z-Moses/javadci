package main.dci.domains.products;

import main.dci.domains.accounts.AssetAccount;

public class SavingsAccount extends AssetAccount {
	public SavingsAccount(String name, int accountID, int userID, 
			double startingBalance) {
		super(name, accountID, userID, startingBalance, ProductTypes.SAVINGSACCOUNT);
	}
}
