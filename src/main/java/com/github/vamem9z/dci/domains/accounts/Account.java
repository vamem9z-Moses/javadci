package main.java.com.github.vamem9z.dci.domains.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.ToString;
import main.java.com.github.vamem9z.dci.domains.accounts.types.AccountTypes;
import main.java.com.github.vamem9z.dci.domains.entries.EntryItem;

@ToString(includeFieldNames=true)
public abstract class Account {
	protected AccountInfo accountInfo;
	protected ArrayList<EntryItem> entries;

	public Account(String name, int accountID, int userID, 
			double startingBalance, 
			AccountTypes productCategory) {
		super();	
		this.accountInfo = new AccountInfo(name, accountID, userID, 
				startingBalance, productCategory);
		
		this.entries = new ArrayList<EntryItem>();
	}
	
	public final String printAccountID() {
		return this.accountInfo.printAccountID();
	}
	
	public final double calcBalance() {
		double balance = this.accountInfo.getStartingBalance();
		
		balance = this.entries.stream().reduce(balance, 
		(sum, e) -> { 
			switch(e.getTransactionType()) {
			case CREDIT:
				sum += e.getAmount();
				break;
			case DEBIT:
				sum -= e.getAmount();
				break;
			}
			return sum;
		}, 
		(sum1, sum2)-> sum1 + sum2);
			
		Double precisionBalance = new BigDecimal(new Double(balance)).
				setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return precisionBalance;
	}
}