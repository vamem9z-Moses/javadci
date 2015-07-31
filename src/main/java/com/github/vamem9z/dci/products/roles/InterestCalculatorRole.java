package com.github.vamem9z.dci.products.roles;

import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.products.AccountProduct;
import com.github.vamem9z.dci.core.roles.Role;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import com.github.vamem9z.dci.core.usecases.results.products.CalculatedInterest;
import com.github.vamem9z.dci.products.usecases.CalculateInterestUseCase;


public interface InterestCalculatorRole extends Role, AccountProduct {
	default Stream<UseCaseResult> calculateInterest(CalculateInterestUseCase ctx){
		
		double interestAmt = ctx.calculateInterestEarned();
		ctx.recordTransaction(interestAmt, AccountActions.DEPOSIT);
		
		return returnResults(new CalculatedInterest(interestAmt));
	}
}
