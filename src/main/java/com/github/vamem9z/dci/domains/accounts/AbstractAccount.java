package main.java.com.github.vamem9z.dci.domains.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.ToString;
import main.java.com.github.vamem9z.dci.accounts.roles.AccountRole;
import main.java.com.github.vamem9z.dci.accounts.roles.TransferMoneySourceRole;
import main.java.com.github.vamem9z.dci.domains.accountinfo.AccountInfo;
import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;

@ToString(includeFieldNames=true)
public abstract class AbstractAccount implements Account, AccountRole, TransferMoneySourceRole {
	
	protected AccountInfo accountInfo;
	protected ArrayList<EntryItem> entries;

	public AbstractAccount(AccountInfo acctInfo) {
		super();	
		this.accountInfo = acctInfo;
		
		this.entries = new ArrayList<EntryItem>();
	}
	
	public final double calcBalance() {
		double balance = this.accountInfo.startingBalance();
		
		balance = this.entries.stream().reduce(
				balance, 
				(sum, e) -> (sum += e.transactionAmount()), 
				(sum1, sum2)-> sum1 + sum2);
			
		Double precisionBalance = new BigDecimal(new Double(balance)).
				setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return precisionBalance;
	}
	
	public final String printAccountID() {
		return this.accountInfo.printAccountID();
	}
	
	public abstract void recordTransaction(double amount, String msg, AccountActions actions);
}