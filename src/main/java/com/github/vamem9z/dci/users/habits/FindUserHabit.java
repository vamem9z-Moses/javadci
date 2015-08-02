/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.vamem9z.dci.users.habits;

import java.util.stream.Stream;

import com.github.vamem9z.dci.core.usecases.UseCase;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import com.github.vamem9z.dci.users.roles.UnknownUserRole;

/**
 *
 * @author mmiles
 */

public final class FindUserHabit implements UseCase {
	
	public FindUserHabit() {}
	
    private UnknownUserRole user;
    
    public Stream<UseCaseResult> execute() {
        return user.findUser(this);
    }
    
    public UnknownUserRole user() {
    	return this.user();
    }
}
