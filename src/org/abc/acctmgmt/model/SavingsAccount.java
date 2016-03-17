package org.abc.acctmgmt.model;

public class SavingsAccount extends Account {

	public SavingsAccount() {
	}
	
	public SavingsAccount(String name, double amt) {
		type = "Savings";
	}
}
