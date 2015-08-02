package com.github.vamem9z.dci.core.domains.results.users;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class UserNotFound extends UserResult{
    public UserNotFound() {
        super("User Not Found", ResultTypes.FAILURE);
    }
}
