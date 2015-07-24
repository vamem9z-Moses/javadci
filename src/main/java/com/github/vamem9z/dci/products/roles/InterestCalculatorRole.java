package main.java.com.github.vamem9z.dci.products.roles;

import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.domains.accounts.AccountActions;
import main.java.com.github.vamem9z.dci.domains.products.AccountProduct;
import main.java.com.github.vamem9z.dci.products.usecases.CalculateInterestUseCase;
import main.java.com.github.vamem9z.dci.roles.Role;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.products.CalculatedInterest;


public interface InterestCalculatorRole extends Role, AccountProduct {
	default Stream<UseCaseResult> calculateInterest(CalculateInterestUseCase ctx){
		
		double interestAmt = ctx.calculateInterestEarned();
		ctx.recordTransaction(interestAmt, AccountActions.DEPOSIT);
		
		return returnResults(new CalculatedInterest(interestAmt));
	}
}
