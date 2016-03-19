package org.abc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.abc.acctmgmt.model.Transaction;

import com.google.gson.Gson;

@Path("/txn")
public class RestService {

	@GET
	@Produces("text/html")
	@Path("/hello1")
	public String sayHello() {
		return "<html><body><h2>Hello Suren</h2></body></html>";

	}

	@GET
	@Produces("text/plain")
	@Path("/hello2")
	public String sayHello2() {
		return "Temp";

	}

	@GET
	@Produces("application/json")
	@Path("/gettxn")
	public String getTxn() {

		Transaction t1 = new Transaction(129, "2016-01-02", "description", 34.0f);
		Transaction t2 = new Transaction(129, "2016-02-02", "descr2", 66.0f);

		List<Transaction> list = new ArrayList<Transaction>();
		list.add(t1);
		list.add(t2);

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
