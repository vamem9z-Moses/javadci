package main.java.com.github.vamem9z.dci.domains.accountinfo.types;

import main.java.com.github.vamem9z.dci.domains.accountinfo.AbstractAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;

public final class VendorAccountInfo extends AbstractAccountInfo {
	public VendorAccountInfo (int accountID, int customerId, double startingBalance) {
		super(accountID, customerId, startingBalance, AccountTypes.VENDORACCOUNT);
	}

}