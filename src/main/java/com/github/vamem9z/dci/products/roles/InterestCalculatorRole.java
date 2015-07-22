package main.java.com.github.vamem9z.dci.products.roles;

import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.domains.products.AccountProduct;
import main.java.com.github.vamem9z.dci.products.usecases.CalculateInterestUseCase;
import main.java.com.github.vamem9z.dci.roles.Role;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.Success;


public interface InterestCalculatorRole extends Role, AccountProduct {
	default Stream<UseCaseResult> calculateInterest(CalculateInterestUseCase ctx){
		
		double interestAmt = ctx.calc.account().calcBalance()/(ctx.timePeriod.period);
		ctx.calc.account().recordTransaction(interestAmt, 
				String.format("%s Interest", ctx.timePeriod.formattedName), 
				AccountActions.DEPOSIT);
		
		return (Arrays.asList((UseCaseResult) new Success())).stream();
	}
}
