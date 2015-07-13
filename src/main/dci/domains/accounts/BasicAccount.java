package main.dci.domains.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.dci.domains.entries.EntryItem;

public interface BasicAccount {
	AccountInfo getAccountInfo();
	ArrayList<EntryItem> getEntries();
	void recordTransaction(double amount, String msg, AccountActions actions);
	
	default double getBalance() {
		double balance = this.getAccountInfo().getStartingBalance();
		
		balance = this.getEntries().stream().reduce(balance, 
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
