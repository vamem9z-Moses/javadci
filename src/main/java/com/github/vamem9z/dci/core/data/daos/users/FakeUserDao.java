/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.vamem9z.dci.core.data.daos.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.github.vamem9z.dci.core.data.daos.Dao;
import com.github.vamem9z.dci.core.domains.results.AbstractResult;
import com.github.vamem9z.dci.core.domains.results.users.FoundUser;
import com.github.vamem9z.dci.core.domains.results.users.TooManyUsers;
import com.github.vamem9z.dci.core.domains.results.users.UserNotFound;
import com.github.vamem9z.dci.core.domains.users.User;

public final class FakeUserDao implements Dao {
    private static User Moses = new User(12, "Moses");
    private static User Kathy = new User(13, "Kathy");
    private static User David = new User(14, "David");
    private static User Vendor1 =  new User(15, "Vendor1");
    private static User Vendor2 = new User(16, "Vendor 2");
    private static ArrayList<User>  users = new ArrayList<User>(Arrays.asList(Moses, 
            Kathy, David, Vendor1, Vendor2));
    
    public FakeUserDao() {}
    
    public final AbstractResult findUserByID(int id) {
        ArrayList<User> foundUsers = users.stream().filter(user -> user.id() == id).collect(Collectors.toCollection(ArrayList::new));
        if (foundUsers.isEmpty()) {
            return new UserNotFound();
        }
        else if(foundUsers.size() > 1) {
            return new TooManyUsers();
        }
        return new FoundUser(users.get(0));
    }
}
