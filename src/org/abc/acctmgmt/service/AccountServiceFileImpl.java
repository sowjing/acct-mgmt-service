package org.abc.acctmgmt.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.abc.acctmgmt.model.Account;
import org.abc.acctmgmt.model.Transaction;

public class AccountServiceFileImpl implements AccountService {
	final String file = "C:/Dev/AccountData/account.txt";

	public void creditOrDebit(Account acct) {
		acct.setBalance(acct.getBalance() + acct.getAmount());
	}

	// write to file
	public void save(Account acct) {
		try {
			// get current date
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String today = df.format(new Date());

			FileWriter fw = new FileWriter(file, true);

			String line = today + "," + acct.getDescription() + "," + acct.getAmount() + "," + acct.getBalance() + "\n";
			fw.write(line);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read account data file
	public void load(Account acct) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			String lastLine = null;
			while ((line = br.readLine()) != null) {
				lastLine = line;
			}

			// set the balance value
			String[] arr = lastLine.split(",");
			acct.setBalance(Double.parseDouble(arr[3]));

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public List<Transaction> printStatement() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			String[] stmt = new String[5];
			while ((line = br.readLine()) != null) {
				stmt[0] = stmt[1];
				stmt[1] = stmt[2];
				stmt[2] = stmt[3];
				stmt[3] = stmt[4];
				stmt[4] = line;

			}
			// print statement in reverse order
			for (int i = stmt.length - 1; i >= 0; i--) {
				System.out.println(stmt[i]);
			}
			br.close();

			// EmailUtil.email("surendra_kumar_n@yahoo.com","Your Bank
			// Statement", Arrays.toString(stmt));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}

	/**
	 * Prints statement for a given month
	 * 
	 * @param month
	 */
	public void printStatement(String month) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String ln = line;

				String[] arr = ln.split(",");
				String date = arr[0];

				String fileMonth = date.substring(0, 2);

				if (fileMonth.equalsIgnoreCase(month)) {
					System.out.println(ln);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Prints statement between two input dates
	 * 
	 * @param fromDate
	 * @param toDate
	 * @throws ParseException
	 */
	public void printStatement(String fromDate, String toDate) {
		try {
			// get current date
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date fromDt = df.parse(fromDate);
			Date toDt = df.parse(toDate);

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = br.readLine()) != null) {

				// set the balance value
				String[] arr = line.split(",");
				String txnDate = arr[0];

				Date txnDt = df.parse(txnDate);

				if ((txnDt.equals(fromDt) || txnDt.after(fromDt)) && (txnDt.equals(toDt) || txnDt.before(toDt))) {
					System.out.println(line);
				}
			}
			br.close();
		} catch (IOException | ParseException e) {
			System.out.println("Input values=" + fromDate + ";" + toDate);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String today = df.format(new Date());

		System.out.println(today);
	}
}
