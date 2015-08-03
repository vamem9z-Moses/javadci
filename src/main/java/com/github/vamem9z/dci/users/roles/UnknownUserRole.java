/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.vamem9z.dci.users.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import com.github.vamem9z.dci.core.data.daos.users.FakeUserDao;
import com.github.vamem9z.dci.core.domains.results.Result;
import com.github.vamem9z.dci.core.domains.results.users.UserNotFound;
import com.github.vamem9z.dci.core.roles.Role;
import com.github.vamem9z.dci.users.habits.FindUserHabit;

/**
 *
 * @author mmiles
 */
public interface UnknownUserRole extends Role {
    public int id();
    
    default Stream<Result> findUser(FindUserHabit ctx) {
        if (ctx.user().id() > 0) {
            FakeUserDao userDao = new FakeUserDao();
            Result result = userDao.findUserByID(ctx.user().id());
            return new ArrayList<Result>(Arrays.asList(result)).stream();
        }
        return new ArrayList<Result>(Arrays.asList(new UserNotFound())).stream();
    }
}
