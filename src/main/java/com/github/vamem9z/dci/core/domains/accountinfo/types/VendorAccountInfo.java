package com.github.vamem9z.dci.core.domains.accountinfo.types;

import com.github.vamem9z.dci.core.domains.accountinfo.AbstractAccountInfo;
import com.github.vamem9z.dci.core.domains.accounts.types.AccountTypes;

public final class VendorAccountInfo extends AbstractAccountInfo {
	public VendorAccountInfo (int accountID, int customerId, double startingBalance) {
		super(accountID, customerId, startingBalance, AccountTypes.VENDORACCOUNT);
	}

}
