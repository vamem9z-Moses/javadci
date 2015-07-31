package com.github.vamem9z.dci.core.domains.accounts.types;

import com.github.vamem9z.dci.core.domains.accountinfo.types.SavingsAccountInfo;
import com.github.vamem9z.dci.core.domains.accounts.AbstractAssetAccount;

public final class SavingsAccount extends AbstractAssetAccount {
	public SavingsAccount(SavingsAccountInfo acctInfo) {
		super(acctInfo);
	}
}
