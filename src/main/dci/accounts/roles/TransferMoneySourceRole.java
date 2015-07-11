package main.dci.accounts.roles;

import java.util.ArrayList;

import main.dci.accounts.contexts.AccountDepositContext;
import main.dci.accounts.contexts.AccountWithDrawContext;
import main.dci.accounts.contexts.PayBillsContext;
import main.dci.accounts.contexts.TransferMoneyContext;
import main.dci.contexts.ContextResult;

public interface TransferMoneySourceRole extends BasicAccountRole {	
	
	default ArrayList<ContextResult> transfer(TransferMoneyContext ctx) {
		
		String withDrawMsg = String.format("Transfer Out %d to Transfer %d", 
				ctx.getSourceAccount().getAccountInfo().getAccountID(),
				ctx.getDestAccount().getAccountInfo().getAccountID());
		
		String depositMsg = String.format("Transfer Out %d to Transfer %d", 
				ctx.getDestAccount().getAccountInfo().getAccountID(),
				ctx.getSourceAccount().getAccountInfo().getAccountID());
		
		AccountWithDrawContext accWithCtx  = new AccountWithDrawContext(
				ctx.getSourceAccount().getAccountDomain(), 
				ctx.getAmount(), withDrawMsg);
		accWithCtx.execute();
				
		AccountDepositContext accDepCtx = new AccountDepositContext(
				ctx.getDestAccount(), ctx.getAmount(), depositMsg);
		accDepCtx.execute();
		
		return returnResults(ContextResult.SUCCESS);
	}
	
	default ArrayList<ContextResult> payBill(TransferMoneySourceRole source, 
			AccountRole creditor) {
		TransferMoneyContext tmctx = new TransferMoneyContext(
				source, creditor, creditor.getBalance());	
		return tmctx.execute();
	}
	
	default ArrayList<ContextResult> payBills(PayBillsContext ctx) {
	
		ArrayList<ContextResult> errors = new ArrayList<ContextResult>();

		ctx.getCreditors().stream().
			map(creditor ->  {return payBill(ctx.getSourceAccount(), creditor);}).
			forEach(errs -> errors.addAll(errs));
		
		return errors;
	}
}	
	