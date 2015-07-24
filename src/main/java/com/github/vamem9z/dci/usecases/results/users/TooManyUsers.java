package main.java.com.github.vamem9z.dci.usecases.results.users;

import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResultTypes;

public final class TooManyUsers extends UserResult {
    public TooManyUsers() {
        super("Too Many Users", UseCaseResultTypes.FAILURE);
    }
}
