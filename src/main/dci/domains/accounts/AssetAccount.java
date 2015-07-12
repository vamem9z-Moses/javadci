package main.dci.domains.accounts;

import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;
import main.dci.domains.entries.CreditEntryItem;
import main.dci.domains.entries.DebitEntryItem;
import main.dci.domains.products.ProductTypes;

public abstract class AssetAccount extends Account implements AccountRole, TransferMoneySourceRole {
	public AssetAccount(String name, int accountID, int userID, 
			double startingBalance,  
			ProductTypes productCategory) {
		super(name, accountID, userID, startingBalance, productCategory);
	}
	
	public void recordTransaction(double amount, String msg, AccountActions actions) {
		switch (actions) {
			case DEPOSIT:
				entries.add(new CreditEntryItem(this.accountInfo.getAccountID(), msg, amount));
				break;
			case WITHDRAWAL:
				entries.add(new DebitEntryItem(this.accountInfo.getAccountID(), msg, amount));
				break;
		}		
	}
}
