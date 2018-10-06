package sk.itlearning.java5.jpa.resloc.main;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sk.itlearning.java5.jpa.resloc.model.Customer;
import sk.itlearning.java5.jpa.resloc.service.CustomerService;

@Path("client")
public class Page {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	public Response findAll() {
		JsonObjectBuilder jb = Json.createObjectBuilder();
		List<Customer> customers = CustomerService.findAll();
		for (Customer c : customers) {
			jb.add(String.valueOf(c.getId()), c.getCustomerName());
		}
		return Response.ok(jb.build()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("put/{name}")
	public Response create(@PathParam("name") String name) {
		JsonObjectBuilder jb = Json.createObjectBuilder();
		Customer c = new Customer();
		c.setCustomerName(name);
		CustomerService.create(c);
		return Response.ok(jb.build()).build();
	}
	
}
