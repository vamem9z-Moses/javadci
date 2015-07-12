package test.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.contexts.ContextResult;
import main.dci.domains.accounts.Account;
import main.dci.domains.products.CheckingAccount;
import main.dci.domains.products.VendorAccount;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountWithDrawContextTest {
		
	private static Account creditAccount = new CheckingAccount("Moses", 123, 
			12, 1000.34);
	
    private static Account debitAccount = new VendorAccount("Moses", 123, 
                12, 1000.34);
    
    private AccountWithDrawContext ctx;

    @DataProvider(name="account test data")
    public Object[][] data() {
    	return new Object[][] {
    			{creditAccount, ContextResult.SUCCESS, 400.00, 600.34, "Credit Account Withdraw Test"},
    			{debitAccount, ContextResult.SUCCESS, 400.00, 1400.34, "Deposit Account Withdraw Test"}
    	};
    }

    @Test(dataProvider="account test data")
	public void test(AccountRole account, ContextResult expectedResult, double amount, double expected, String msg) {
		double balance;
		ctx = new AccountWithDrawContext(account, amount, msg);
		Stream<ContextResult> results = ctx.execute();
		ArrayList<ContextResult> errors = results.collect(Collectors.toCollection(ArrayList::new));
		balance = account.getBalance();
		assertEquals(balance, expected, 0.00, msg);
		assertEquals(errors.size(),1);
		assertEquals(errors.get(0), expectedResult);
	}
}