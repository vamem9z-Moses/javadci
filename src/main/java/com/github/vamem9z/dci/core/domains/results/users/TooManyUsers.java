package com.github.vamem9z.dci.core.domains.results.users;

import com.github.vamem9z.dci.core.domains.results.ResultTypes;

public final class TooManyUsers extends UserResult {
    public TooManyUsers() {
        super("Too Many Users", ResultTypes.FAILURE);
    }
}
