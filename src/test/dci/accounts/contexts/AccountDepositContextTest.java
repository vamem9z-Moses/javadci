package test.dci.accounts.contexts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NoArgsConstructor;
import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.roles.AccountRole;
import main.dci.contexts.ContextResult;
import main.dci.domains.accounts.Account;
import main.dci.domains.products.CheckingAccount;
import main.dci.domains.products.VendorAccount;

@NoArgsConstructor
public class AccountDepositContextTest {
		
	private Account creditAccount = new CheckingAccount("Moses", 123, 12, 1000.34);
	private Account creditAccount1 = new CheckingAccount("Moses", 123, 12, 200.34);
    private Account debitAccount = new VendorAccount("Moses", 123, 12, 1000.34);   
    private Account debitAccount1 = new VendorAccount("Moses", 123, 12, 2000.34); 
    
    private AccountDepositContext ctx;

    @DataProvider(name="account test data")
    public Object[][] data() {
    	return new Object[][] {
    			{creditAccount, ContextResult.SUCCESS,  400.00, 1400.34, "Credit Account Deposit Test"},
    			{debitAccount, ContextResult.SUCCESS, 400.00, 600.34, "Deposit Account Deposit Test"},
    			{creditAccount1, ContextResult.FAILURE, -200.00, 200.34, "Credit Account Negative Amount"},
    			{debitAccount1, ContextResult.FAILURE, -400.00, 2000.34, "Deposit Account Deposit Test"}
    	};
    }

    @Test(dataProvider="account test data")
	public void test(AccountRole account, ContextResult expectedResult, double amount, double expected, String msg) {
		ctx = new AccountDepositContext(account, amount, msg);
		Stream<ContextResult> results  = ctx.execute();
		ArrayList<ContextResult> errors = results.collect(Collectors.toCollection(ArrayList::new));
		double balance = account.getBalance();
		assertEquals(balance, expected, 0.00, msg);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0), expectedResult);
	}
}