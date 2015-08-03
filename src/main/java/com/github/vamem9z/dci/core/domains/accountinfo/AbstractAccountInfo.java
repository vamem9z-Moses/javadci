package com.github.vamem9z.dci.core.domains.accountinfo;


import java.util.ArrayList;
import java.util.Arrays;

import com.github.vamem9z.dci.core.domains.AbstractFields;
import com.github.vamem9z.dci.core.domains.accounts.types.AccountTypes;

/**
 * Base class for accountInfo types
 * <p> 
 * @author mmiles
 *
 */
public abstract class AbstractAccountInfo extends AbstractFields implements AccountInfo {
	
	private final int accountId;
	private final int customerId;
	private final double startingBalance;
	private final AccountTypes productCategory;
	
	/**
	 * Constructor
	 * <p>
	 * @param accountId unique account identifier
	 * @param customerId unique customer identifier
	 * @param startingBalance beginning balance of the account
	 * @param accountType type of account
	 */
	public AbstractAccountInfo(int accountId, int customerId, double startingBalance, 
			AccountTypes accountType) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.startingBalance = startingBalance;
		this.productCategory = accountType;
	}
	
	/**
	 * Returns the accountId as a String
	 */
	public final String printAccountID() {
		return String.valueOf(this.accountId);
	}
	
	/**
	 * Returns the accountId as an int
	 */
	public final int accountId() {
		return this.accountId;
	}
	
	/**
	 * Returns the accounts starting balance
	 */
	public final double startingBalance() {
		return this.startingBalance;
	}
	
	/**
	 * Sets the fields for equals, toString, and hashCode methods
	 */
	public final ArrayList<Object> fields() {
		return new ArrayList<Object>(Arrays.asList(this.accountId, 
				this.customerId, this.startingBalance, this.productCategory));
	}
}
	
