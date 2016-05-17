package com.github.vamem9z.dci.core.domains.accounts.types;

import com.github.vamem9z.dci.core.domains.accountinfo.types.CheckingAccountInfo;
import com.github.vamem9z.dci.core.domains.accounts.AbstractAssetAccount;

public final class CheckingAccount extends AbstractAssetAccount {
	public CheckingAccount(CheckingAccountInfo acctInfo) {
		super(acctInfo);
	}
}