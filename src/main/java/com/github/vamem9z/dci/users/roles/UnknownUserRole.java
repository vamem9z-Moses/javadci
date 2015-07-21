/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.users.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.results.users.UserNotFound;
import main.java.com.github.vamem9z.dci.roles.Roler;
import main.java.com.github.vamem9z.dci.users.contexts.FindUserContext;
import main.java.com.github.vamem9z.dci.users.UserDao;

/**
 *
 * @author mmiles
 */
public interface UnknownUserRole extends Roler {
    public int getId();
    
    public default Stream<ContextResult> findUser(FindUserContext ctx) {
        if (ctx.getUser().getId() > 0) {
            UserDao userDao = new UserDao();
            ContextResult result = userDao.findUserByID(ctx.getUser().getId());
            return new ArrayList<ContextResult>(Arrays.asList(result)).stream();
        }
        return new ArrayList<ContextResult>(Arrays.asList(new UserNotFound())).stream();
    }
}
