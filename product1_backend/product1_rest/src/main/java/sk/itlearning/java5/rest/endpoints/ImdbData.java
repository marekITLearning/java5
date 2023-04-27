package sk.itlearning.java5.rest.endpoints;

import java.time.LocalDateTime;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sk.itlearning.java5.conf.AppConfig;
import sk.itlearning.java5.model.MovieRequest;
import sk.itlearning.java5.pers.service.TitleService;

@Path("movie")
public class ImdbData {
	
	@Inject
	TitleService titleService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieByRequestParams(MovieRequest request) {

		StringBuffer sb = new StringBuffer();

		sb.append("Production environment: " + AppConfig.isProdEnvironment());

		sb.append("\n");

		sb.append("Dummy imdb movies message... Db layer not yet ready...");

		sb.append("\n");

		sb.append("Current time: " + LocalDateTime.now().toString());
		
		if (request.getPageSize() > 1000) {
			throw new IllegalArgumentException("Maximum value for pageSize is 1000");
		}

		return Response.ok(titleService.getMovieByRequestParams(request)).build();
	}
	
	@DELETE
	@Path("delete/{primaryKey}")
	public Response deleteMovie(@PathParam("primaryKey") String primaryKey) {
		titleService.deleteMovie(primaryKey);
		return Response.ok().build();
	}

}
