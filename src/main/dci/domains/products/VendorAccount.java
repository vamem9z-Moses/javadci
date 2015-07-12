package main.dci.domains.products;

import main.dci.domains.accounts.LiabilityAccount;

public class VendorAccount extends LiabilityAccount {
	public VendorAccount(String name, int accountID, int userID, 
			double startingBalance) {
		super(name, accountID, userID, startingBalance, ProductTypes.VendorAccount);
	}
}
