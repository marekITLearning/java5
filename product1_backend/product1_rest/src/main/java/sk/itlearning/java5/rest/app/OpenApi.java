package sk.itlearning.java5.rest.app;

import javax.ws.rs.Path;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(info = @Info(
		title = "Java 5 moviedb service", 
		version = "1.0.0", 
		description = "Java 5 moviedb service", 
		contact = @Contact(email = "mla@digitalsystems.eu")), 
		tags = {@Tag(name = "movie")},
		servers = { @Server(url = "https://localhost:8081/restapi/api") })
@Path("openapi.yaml")
public class OpenApi {

}
