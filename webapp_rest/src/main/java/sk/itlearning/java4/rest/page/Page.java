package sk.itlearning.java4.rest.page;


import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sk.itlearning.java5.jpa.resloc.model.Customer;
import sk.itlearning.java5.jpa.resloc.service.CustomerService;

@Path("test")
public class Page {

	@Inject CustomerService cs; 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doTest() {
		JsonObjectBuilder jb = Json.createObjectBuilder();
		
//		jb.add("Aktualny cas", LocalDateTime.now().toString());
		
		List<Customer> list = cs.findAll();
		
		list.forEach(e -> jb.add(String.valueOf(e.getId()), e.getCustomerName()));
		
		
		return Response.ok(jb.build()).build();
	}
	
}
