package sk.itlearning.java5.rest.endpoints;

import java.time.LocalDateTime;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sk.itlearning.java5.conf.AppConfig;
import sk.itlearning.java5.model.MovieRequest;

@Path("movie")
public class ImdbData {

	@POST
	@Produces(MediaType.TEXT_HTML)
	public Response getMovieByRequestParams(MovieRequest request) {

		StringBuffer sb = new StringBuffer();

		sb.append("Production environment: " + AppConfig.isProdEnvironment());

		sb.append("\n");

		sb.append("Dummy imdb movies message... Db layer not yet ready...");

		sb.append("\n");

		sb.append("Current time: " + LocalDateTime.now().toString());

		return Response.ok(sb.toString()).build();
	}

}
