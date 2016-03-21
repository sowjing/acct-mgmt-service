package org.abc.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.abc.acctmgmt.model.Transaction;
import org.abc.acctmgmt.service.AccountService;
import org.abc.acctmgmt.service.AccountServiceDBImpl;

import com.google.gson.Gson;

@Path("/txn")
public class RestService {

	AccountService aservice = new AccountServiceDBImpl();

	@GET
	@Produces("application/json")
	@Path("/gettxn")
	public String getTxn() {

		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		List<Transaction> list = aservice.printStatement();

		Gson gson = new Gson();
		return gson.toJson(list);
	}

	@POST
	@Produces("text/plain")
	@Path("/addtxn")
	public String addTxn(String desc, String amt, String crdb) {
		System.out.println(desc + "-" + amt + "-" + crdb);
		return "success666";
	}

}
