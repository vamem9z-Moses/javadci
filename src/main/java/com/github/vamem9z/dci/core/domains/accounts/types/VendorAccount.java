package main.java.com.github.vamem9z.dci.core.domains.accounts.types;

import main.java.com.github.vamem9z.dci.core.domains.accountinfo.types.VendorAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accounts.AbstractLiabilityAccount;

public final class VendorAccount extends AbstractLiabilityAccount {
	public VendorAccount(VendorAccountInfo acctInfo) {
		super(acctInfo);
	}
}
