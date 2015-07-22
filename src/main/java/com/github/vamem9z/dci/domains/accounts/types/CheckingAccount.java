package main.java.com.github.vamem9z.dci.domains.accounts.types;

import main.java.com.github.vamem9z.dci.domains.accountinfo.types.CheckingAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accounts.AbstractAssetAccount;

public final class CheckingAccount extends AbstractAssetAccount {
	public CheckingAccount(CheckingAccountInfo acctInfo) {
		super(acctInfo);
	}
}
