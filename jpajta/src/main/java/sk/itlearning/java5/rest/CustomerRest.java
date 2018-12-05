package sk.itlearning.java5.rest;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import sk.itlearning.java5.jpa.model.Customer;
import sk.itlearning.java5.jpa.model.CustomerService;

/**
 * <p>With latest 2.1 JAXRS API you can think of single request as having multiple responses.
 * 
 * <p>API allows for non-blocking interceptors and filters.
 * 
 * <p>This class will be deployed inside a web application (war) and can be run on any JEE compliant server.
 * 
 * <p>2.1 release came with Reactive Client API.
 * 
 * <p>There is also better async support based on new Java 8 concurrency features.
 * 
 * <p>You can also use Server Sent Events for one-way async updates to the client.
 * 
 * <p>SSE also enables communication channel kept open.
 * 
 * <p>WebSockets allow for bidirectional communication between client and server.
 * 
 * <p>With SSE client can subscribe to updates from the server.
 * 
 * <p>WebSockets can be used for even more complex use cases.
 * 
 * <p>HTTP/2 Push is unrelated to the two mechanisms described and is designed to push assets to the web
 * browser in advance to avoid multiple round trips.
 * 
 * <p>Interceptors, filters and other are provided with @Provider annotation on class. These can be thought of
 * as layers sitting between the originating request and the endpoints. This feature allows for separating the
 * infrastructure code from actual business logic.
 * 
 * <p>Providers can be entity providers, context providers and exception mapping providers.
 * 
 * <p>Entity providers are typically MessageBodyReader and MessageBodyWriter
 * 
 * <p>There are strategies dealing with complexity of distributed communication such as Bulkhead, Circuit-Breaker or Timeout.
 * 
 * <p>REST is dominating in communication between microservices. Message format is typically JSON and XML.
 * 
 * <p>REST service typically publishes a API.
 * 
 * <p>Communication can be asynchronous publish-subscribe model.
 * 
 * <p>With growing complexity (number of point-to-point nodes) and number of services you might want to deploy API Gateway
 * acting almost in the same way as Enterprise Service Bus. 
 * 
 * <p><img src="http://lessons.javaschool.eu/img/jaxrs_resource_uri_recommendations.png" />
 * 
 * <p>Attributes of the resource can be part of the query string such as /users?status=active&gender=male
 * 
 * <p>Use HTTP response codes as part of response signal to the invocation status
 * 
 * <p>Use JSON as the default API request and response communication format
 * 
 * <p>Use some form of version identifier in request and/or response
 * 
 * <p>A new instance of a resource class will be used for each request.
 * 
 * <p>If request method does not match to uri and method annotation, the 404 is returned.
 * 
 * <p>Checking of media type of input body returns 415 if none is found.
 * 
 * <p>Checking of media type of output data format returns 406 if none is found.
 * 
 */
@Path("customer")
public class CustomerRest {

	@Inject
	private CustomerService cs;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Customer c) {
		cs.create(c);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAll() {
		List<Customer> list = cs.read();
		String jsonArray = new Gson().toJson(list);
		return Response.ok(jsonArray).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") int id) {
		List<Customer> list = cs.read();
		String jsonArray = new Gson().toJson(list);
		return Response.ok(jsonArray).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id) {
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		return Response.ok().build();
	}
	
	// Beyond the basics
	
	@DefaultValue("v1") @HeaderParam("X-version")
	private String apiVersion;
	
	@GET
	@Path("advanced/{id}")
	public Response advancedUse(
			@PathParam("id") int id,
			@Context UriInfo uriInfo // @QueryParam, @HeaderParam, @CookieParam, @MatrixParam, @DefaultValue
			) {
		return Response.ok().build();
	}
	
	@GET
	@Path("advanced/void")
	public void voidMethod() {
		// returns empty response body with HTTP 204 denoting no content
	}
	
	@GET
	@Path("advanced/generic")
	public GenericEntity<Customer> genericEntityMethod() {
		Customer c = null;
		return new GenericEntity<Customer>(c, Customer.class); // returns HTTP 200 or else 204
	}
	
}
