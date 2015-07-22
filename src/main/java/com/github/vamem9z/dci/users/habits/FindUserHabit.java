/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.users.habits;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import main.java.com.github.vamem9z.dci.usecases.UseCase;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.users.roles.UnknownUserRole;

/**
 *
 * @author mmiles
 */
@AllArgsConstructor
public final class FindUserHabit implements UseCase {
    private UnknownUserRole user;
    
    public Stream<UseCaseResult> execute() {
        return user.findUser(this);
    }
    
    public UnknownUserRole user() {
    	return this.user();
    }
}
