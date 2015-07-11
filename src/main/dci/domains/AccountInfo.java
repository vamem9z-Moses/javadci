package main.dci.domains;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import main.dci.domains.AccountDomain.ACCOUNTTYPES;
import main.dci.domains.AccountDomain.PRODUCTTYPES;

@Data
@ToString(includeFieldNames=true)
@AllArgsConstructor
public class AccountInfo {
	private String name;
	private int accountID;
	private int userID;
	private double startingBalance;
	private ACCOUNTTYPES accountType;
	private PRODUCTTYPES productCategory;
}
	
