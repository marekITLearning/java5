package sk.itlearning.java5.rest.endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import sk.itlearning.java5.biz.email.EmailSender;
import sk.itlearning.java5.conf.AppConfig;
import sk.itlearning.java5.conf.util.JsonUtil;
import sk.itlearning.java5.model.MovieRequest;
import sk.itlearning.java5.pers.entity.Title;
import sk.itlearning.java5.pers.service.TitleService;
import sk.itlearning.java5.rest.app.ErrorCodes;
import sk.itlearning.java5.rest.app.ErrorResponse;

@Path("movie")
public class ImdbData {

	@Inject
	private TitleService titleService;

	@Operation(summary = "A list of movies from imdb library", tags = {
			"movie" }, requestBody = @RequestBody(required = true, description = "Request body of type MovieRequest. See the documentation of type MovieRequest for all details.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MovieRequest.class))), responses = {
					@ApiResponse(responseCode = "200", description = "Valid response - an array of movies", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Title.class)))),
					@ApiResponse(responseCode = "400", description = "Invalid request. Request in bad format or is missing mandatory request parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
					@ApiResponse(responseCode = "403", description = "Forbidden or not authorized request. Missing or invalid userName or apiKey or forbidden for other reasons.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieByRequestParams(MovieRequest request) {
		if (request == null) {
			return ErrorResponse.build(ErrorCodes.BadDataOrArguments);
		}
		List<Title> list = titleService.getMovieByRequestParams(request);
		
		if (AppConfig.isProdEnvironment()) {
			EmailSender.sendEmail("New user has been registered");
			EmailSender.sendEmail(AppConfig.hostUrl);
		}
		
		return Response.ok(JsonUtil.toJson(list)).build();
	}

}
