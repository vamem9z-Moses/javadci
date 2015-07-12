package main.dci.domains.accounts;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import main.dci.domains.products.ProductTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public class AccountInfo {
	@Getter private String name;
	@Getter private int accountID;
	@Getter private int userID;
	@Getter private double startingBalance;
	private ProductTypes productCategory;
}
	
