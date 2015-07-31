package com.github.vamem9z.dci.core.usecases.results.users;

import com.github.vamem9z.dci.core.domains.users.User;
import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class FoundUser extends UserResult {
    private User user;

    public FoundUser(User user) {
        super("Found User", UseCaseResultTypes.SUCCESS);
        this.user = user;
    }
    
    public User foundUser() {
    	return this.user;
    }
}