package main.java.com.github.vamem9z.dci.core.data.daos.entries;

import java.time.ZonedDateTime;

import main.java.com.github.vamem9z.dci.core.data.daos.Dao;
import main.java.com.github.vamem9z.dci.core.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.core.usecases.results.UseCaseResult;

public interface EntryItemDao extends Dao {
	UseCaseResult save(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType);
}
