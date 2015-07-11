package main.dci.accounts.roles;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.dci.domains.AccountDomain;
import main.dci.domains.AccountDomain.TRANSACTIONTYPES;
import main.dci.domains.AccountInfo;
import main.dci.domains.EntryItem;
import main.dci.roles.Roler;

public interface BasicAccountRole extends Roler {
	AccountInfo getAccountInfo();
	ArrayList<EntryItem> getEntries();
	void recordTransaction(double amount, String msg, TRANSACTIONTYPES transType);
	
	default AccountDomain getAccountDomain() {
		return (AccountDomain)this;
	}
	
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
