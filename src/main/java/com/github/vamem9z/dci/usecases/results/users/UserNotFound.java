package main.java.com.github.vamem9z.dci.usecases.results.users;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public final class UserNotFound extends UserResult{
    public UserNotFound() {
        super("User Not Found", UseCaseResultTypes.FAILURE);
    }
}
