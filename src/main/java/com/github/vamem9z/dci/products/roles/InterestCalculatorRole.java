package main.java.com.github.vamem9z.dci.products.roles;

import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.domains.products.ProductAccounter;
import main.java.com.github.vamem9z.dci.products.contexts.CalculateInterestContext;
import main.java.com.github.vamem9z.dci.roles.Roler;


public interface InterestCalculatorRole extends Roler, ProductAccounter {
	default Stream<ContextResult> calculateInterest(CalculateInterestContext ctx){
		
		double interestAmt = ctx.calc.getAccount().getBalance()/(ctx.timePeriod.period);
		ctx.calc.getAccount().recordTransaction(interestAmt, 
				String.format("%s Interest", ctx.timePeriod.formattedName), 
				AccountActions.DEPOSIT);
		
		return (Arrays.asList(ContextResult.SUCCESS)).stream();
	}
}
