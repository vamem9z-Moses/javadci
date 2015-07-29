package main.java.com.github.vamem9z.dci.core.domains.accounts.types;

import main.java.com.github.vamem9z.dci.core.domains.accountinfo.types.CheckingAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accounts.AbstractAssetAccount;

public final class CheckingAccount extends AbstractAssetAccount {
	public CheckingAccount(CheckingAccountInfo acctInfo) {
		super(acctInfo);
	}
}
