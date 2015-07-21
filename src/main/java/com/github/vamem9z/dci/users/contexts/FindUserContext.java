/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.users.contexts;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;
import main.java.com.github.vamem9z.dci.users.roles.UnknownUserRole;

/**
 *
 * @author mmiles
 */
@AllArgsConstructor
public class FindUserContext implements Contexter {
    @Getter private UnknownUserRole user;
    
    public Stream<ContextResult> execute() {
        return user.findUser(this);
    }
}
