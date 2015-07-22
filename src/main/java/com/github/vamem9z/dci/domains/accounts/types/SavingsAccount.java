package main.java.com.github.vamem9z.dci.domains.accounts.types;

import main.java.com.github.vamem9z.dci.domains.accountinfo.types.SavingsAccountInfo;
import main.java.com.github.vamem9z.dci.domains.accounts.AbstractAssetAccount;

public final class SavingsAccount extends AbstractAssetAccount {
	public SavingsAccount(SavingsAccountInfo acctInfo) {
		super(acctInfo);
	}
}
