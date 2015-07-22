/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.users.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import main.java.com.github.vamem9z.dci.roles.Role;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;
import main.java.com.github.vamem9z.dci.usecases.results.users.UserNotFound;
import main.java.com.github.vamem9z.dci.users.UserDao;
import main.java.com.github.vamem9z.dci.users.habits.FindUserHabit;

/**
 *
 * @author mmiles
 */
public interface UnknownUserRole extends Role {
    public int id();
    
    default Stream<UseCaseResult> findUser(FindUserHabit ctx) {
        if (ctx.user().id() > 0) {
            UserDao userDao = new UserDao();
            UseCaseResult result = userDao.findUserByID(ctx.user().id());
            return new ArrayList<UseCaseResult>(Arrays.asList(result)).stream();
        }
        return new ArrayList<UseCaseResult>(Arrays.asList(new UserNotFound())).stream();
    }
}
