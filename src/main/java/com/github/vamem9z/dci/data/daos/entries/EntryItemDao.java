package main.java.com.github.vamem9z.dci.data.daos.entries;

import java.time.ZonedDateTime;

import main.java.com.github.vamem9z.dci.data.daos.Dao;
import main.java.com.github.vamem9z.dci.domains.entries.TransactionTypes;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface EntryItemDao extends Dao {
	UseCaseResult save(int id, int accountID, String message, ZonedDateTime date, double amount, TransactionTypes transType);
}
