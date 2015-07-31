package com.github.vamem9z.dci.core.domains.accounts.types;

import com.github.vamem9z.dci.core.domains.accountinfo.types.VendorAccountInfo;
import com.github.vamem9z.dci.core.domains.accounts.AbstractLiabilityAccount;

public final class VendorAccount extends AbstractLiabilityAccount {
	public VendorAccount(VendorAccountInfo acctInfo) {
		super(acctInfo);
	}
}
