package main.java.com.github.vamem9z.dci.domains.accounts.types;

import main.java.com.github.vamem9z.dci.domains.accounts.AbstractLiabilityAccount;

public final class VendorAccount extends AbstractLiabilityAccount {
	public VendorAccount(String name, int accountID, int userID, 
			double startingBalance) {
		super(name, accountID, userID, startingBalance, AccountTypes.VENDORACCOUNT);
	}
}
