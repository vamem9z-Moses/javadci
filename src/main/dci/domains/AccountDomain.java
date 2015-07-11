package main.dci.domains;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import main.dci.accounts.roles.AccountRole;
import main.dci.accounts.roles.TransferMoneySourceRole;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
@AllArgsConstructor
public class AccountDomain implements AccountRole, TransferMoneySourceRole {
	
	public enum TRANSACTIONTYPES { CREDIT, DEBIT };
	public enum ACCOUNTTYPES { ASSETACCOUNT, LIABILITYACCOUNT };
	public enum PRODUCTTYPES { SAVINGSACCOUNT, CHECKINGACCOUNT };
	
	@Getter private AccountInfo accountInfo;
	@Getter private ArrayList<EntryItem> entries;

	public AccountDomain(String name, int accountID, int userID, 
			double startingBalance, ACCOUNTTYPES accountType, 
			PRODUCTTYPES productCategory) {
		super();	
		this.accountInfo = new AccountInfo(name, accountID, userID, 
				startingBalance, accountType, productCategory);
		
		this.entries = new ArrayList<EntryItem>();
	}
	
	public void recordTransaction(double amount, String message, TRANSACTIONTYPES transType) {
		EntryItem entry = new EntryItem(this.accountInfo.getAccountID(), message,
				amount, transType);
		this.entries.add(entry);
	}
}