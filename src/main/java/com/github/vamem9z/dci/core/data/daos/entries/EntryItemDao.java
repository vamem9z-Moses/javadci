package com.github.vamem9z.dci.core.data.daos.entries;

import java.time.ZonedDateTime;

import com.github.vamem9z.dci.core.data.daos.Dao;
import com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import com.github.vamem9z.dci.core.domains.results.Result;

public interface EntryItemDao extends Dao {
	Result save(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType);
}
