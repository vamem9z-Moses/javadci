/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.github.vamem9z.dci.contexts.results.users;

import main.java.com.github.vamem9z.dci.contexts.results.Failure;

/**
 *
 * @author mmiles
 */
public final class UserNotFound extends Failure {
    public UserNotFound() {
        this.name ="User Not Found";
        this.code = 501;
    }
}
