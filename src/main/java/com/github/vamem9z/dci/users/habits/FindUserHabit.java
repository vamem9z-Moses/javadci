/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.users.habits;

import java.util.stream.Stream;

import lombok.NoArgsConstructor;
import main.java.com.github.vamem9z.dci.core.usecases.UseCase;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.users.roles.UnknownUserRole;

/**
 *
 * @author mmiles
 */
@NoArgsConstructor
public final class FindUserHabit implements UseCase {
    private UnknownUserRole user;
    
    public Stream<UseCaseResult> execute() {
        return user.findUser(this);
    }
    
    public UnknownUserRole user() {
    	return this.user();
    }
}
