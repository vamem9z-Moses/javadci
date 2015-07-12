package main.dci.domains.accounts;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import main.dci.domains.products.ProductTypes;

@ToString(includeFieldNames=true)
@AllArgsConstructor
public class AccountInfo {
	@Getter @Setter private String name;
	@Getter @Setter private int accountID;
	@Getter @Setter private int userID;
	@Getter @Setter private double startingBalance;
	private ProductTypes productCategory;
}
	
