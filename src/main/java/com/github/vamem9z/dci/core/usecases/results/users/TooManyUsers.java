package com.github.vamem9z.dci.core.usecases.results.users;

import com.github.vamem9z.dci.core.usecases.results.UseCaseResultTypes;

public final class TooManyUsers extends UserResult {
    public TooManyUsers() {
        super("Too Many Users", UseCaseResultTypes.FAILURE);
    }
}
