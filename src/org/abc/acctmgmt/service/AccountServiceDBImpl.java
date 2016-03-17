package org.abc.acctmgmt.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.abc.acctmgmt.model.Account;
import org.abc.acctmgmt.model.Transaction;

public class AccountServiceDBImpl implements AccountService {

	public void creditOrDebit(Transaction transhis) {
		transhis.setBalance(transhis.getBalance() + transhis.getAmount());
	}

	public void save(Account acct) {
		// TODO Auto-generated method stub
	}

	public void save(Transaction transhis) {
		Connection conn = null;

		Properties connectionProps = new Properties();
		connectionProps.put("user", "sowji");
		connectionProps.put("password", "sowji");

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/acctmgmt?useSSL=false", connectionProps);

			String query = "INSERT INTO transaction_history (customer_id,txn_date,description,amount,balance) VALUES ("
					+ transhis.getCustomerId() + ",'" + transhis.getDate() + "','" + transhis.getDescription() + "',"
					+ transhis.getAmount() + "," + transhis.getBalance() + ")";

			System.out.println(query);
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(query);

			stmt.close();
			
			System.out.println("Rows inserted=" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void load(Account acct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStatement() {
		Connection conn = null;

		Properties connectionProps = new Properties();
		connectionProps.put("user", "sowji");
		connectionProps.put("password", "sowji");

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/acctmgmt?useSSL=false", connectionProps);

			String query = "select * from transaction_history";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt(1);
				int csid = rs.getInt(2);
				Date date = rs.getDate(3);
				String desc = rs.getString(4);
				float amt = rs.getFloat(5);
				float bal = rs.getFloat(6);

				System.out.println(id + "," + csid + "," + date + "," + desc + "," + amt + "," + bal);
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void printStatement(String month) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStatement(String fromDate, String toDate) {
		// TODO Auto-generated method stub

	}
}