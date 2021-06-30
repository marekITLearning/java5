package sk.itlearning.java5.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("imdb")
public class ImdbData {

//	@Inject
//	private RatingService ratingService;

	@GET
	@Path("createAndPersist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopRated() {
//		RatingFactory rf = new RatingFactory();
//		return Response.ok(rf.createAndPersistInstance(String.valueOf(new Date().getTime()))).build();
		return Response.ok("Hello World").build();
	}

	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCount() {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		return Response.ok(gson.toJson(ratingService.getAll())).build();
		return Response.ok().build();
	}

	@POST
	@Path("updateRating")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCount(String rating) {
//		Rating dbEntity = ratingService.find(rating.getId());
//		dbEntity.setAveragerating(rating.getAveragerating());
//		ratingService.update(rating);
//		return Response.ok(rating).build();
		return Response.ok().build();
	}

}
