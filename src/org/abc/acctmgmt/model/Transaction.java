package org.abc.acctmgmt.model;

public class Transaction {
	int id;
	int customerId;
	String date;
	String description;
	float amount;
	float balance;
	
	public Transaction(){
	}
	
	public Transaction(int cs_id,String date, String description, float amt){
		customerId = cs_id;
		this.date = date;
		this.description = description;
		amount = amt;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
