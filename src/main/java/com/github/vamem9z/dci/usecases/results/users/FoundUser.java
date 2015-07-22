/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.usecases.results.users;

import lombok.Getter;
import main.java.com.github.vamem9z.dci.domains.users.User;
import main.java.com.github.vamem9z.dci.usecases.results.Success;
/**
 *
 * @author mmiles
 */
public class FoundUser extends Success {
     @Getter private User user;

    public FoundUser(User user) {
        this.name = "Found User";
        this.code = 503;
        this.user = user;
    }
}