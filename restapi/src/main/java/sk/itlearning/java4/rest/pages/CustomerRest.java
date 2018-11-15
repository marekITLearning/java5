package sk.itlearning.java4.rest.pages;


import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customer")
public class CustomerRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doTest() {
		JsonObjectBuilder jb = Json.createObjectBuilder();	
//		List<Customer> list = cs.findAll();
//		list.forEach(e -> jb.add(String.valueOf(e.getId()), e.getCustomerName()));
		return Response.ok(jb.build()).build();
	}
	
}
