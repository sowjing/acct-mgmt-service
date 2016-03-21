package org.abc.acctmgmt.service;

import java.util.List;

import org.abc.acctmgmt.model.Account;
import org.abc.acctmgmt.model.Transaction;

public interface AccountService {
	
	void save(Account acct);

	void load(Account acct);

	List<Transaction> printStatement();

	void printStatement(String month);

	void printStatement(String fromDate, String toDate);

}
