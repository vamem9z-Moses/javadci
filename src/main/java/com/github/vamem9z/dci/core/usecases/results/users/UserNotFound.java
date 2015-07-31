package com.github.vamem9z.dci.core.usecases.results.users;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class UserNotFound extends UserResult{
    public UserNotFound() {
        super("User Not Found", UseCaseResultTypes.FAILURE);
    }
}
