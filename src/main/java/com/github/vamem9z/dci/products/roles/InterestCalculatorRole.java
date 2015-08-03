package com.github.vamem9z.dci.products.roles;

import java.util.stream.Stream;

import com.github.vamem9z.dci.core.domains.accounts.AccountActions;
import com.github.vamem9z.dci.core.domains.products.AccountProduct;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.products.CalculatedInterest;
import com.github.vamem9z.dci.core.roles.Role;
import com.github.vamem9z.dci.products.usecases.CalculateInterestUseCase;


public interface InterestCalculatorRole extends Role, AccountProduct {
	default Stream<Result> calculateInterest(CalculateInterestUseCase ctx){
		
		double interestAmt = ctx.calculateInterestEarned();
		ctx.recordTransaction(interestAmt, AccountActions.DEPOSIT);
		
		return returnResults(new CalculatedInterest(interestAmt));
	}
}
