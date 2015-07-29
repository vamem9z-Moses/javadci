package main.java.com.github.vamem9z.dci.core.domains.accountinfo.types;

import main.java.com.github.vamem9z.dci.core.domains.accountinfo.AbstractAccountInfo;
import main.java.com.github.vamem9z.dci.core.domains.accounts.types.AccountTypes;

public final class CheckingAccountInfo extends AbstractAccountInfo {
	public CheckingAccountInfo (int accountID, int customerId, double startingBalance) {
		super(accountID, customerId, startingBalance, AccountTypes.CHECKINGACCOUNT);
	}

}