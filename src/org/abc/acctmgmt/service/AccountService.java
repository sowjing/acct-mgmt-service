package org.abc.acctmgmt.service;

import org.abc.acctmgmt.model.Account;

public interface AccountService {
	
	void save(Account acct);

	void load(Account acct);

	void printStatement();

	void printStatement(String month);

	void printStatement(String fromDate, String toDate);

}
