package com.github.vamem9z.dci.core.domains.accountinfo;


import lombok.AllArgsConstructor;
import lombok.ToString;
import com.github.vamem9z.dci.core.domains.accounts.types.AccountTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public abstract class AbstractAccountInfo implements AccountInfo {
	private final int accountId;
	private final int customerId;
	private final double startingBalance;
	private final AccountTypes productCategory;
	
	public final String printAccountID() {
		return String.valueOf(this.accountId);
	}
	
	public final int accountId() {
		return this.accountId;
	}
	
	public final double startingBalance() {
		return this.startingBalance;
	}
}
	
