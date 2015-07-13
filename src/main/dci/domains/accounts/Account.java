package main.dci.domains.accounts;

import java.util.ArrayList;

import lombok.Getter;
import lombok.ToString;
import main.dci.domains.accounts.types.AccountTypes;
import main.dci.domains.entries.EntryItem;

@ToString(includeFieldNames=true)
public abstract class Account {
	
	@Getter protected AccountInfo accountInfo;
	@Getter protected ArrayList<EntryItem> entries;

	public Account(String name, int accountID, int userID, 
			double startingBalance, 
			AccountTypes productCategory) {
		super();	
		this.accountInfo = new AccountInfo(name, accountID, userID, 
				startingBalance, productCategory);
		
		this.entries = new ArrayList<EntryItem>();
	}
	
}