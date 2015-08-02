package com.github.vamem9z.dci.core.domains.results.users;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;
import com.github.vamem9z.dci.core.domains.users.User;

public final class FoundUser extends UserResult {
    private User user;

    public FoundUser(User user) {
        super("Found User", ResultTypes.SUCCESS);
        this.user = user;
    }
    
    public User foundUser() {
    	return this.user;
    }
}