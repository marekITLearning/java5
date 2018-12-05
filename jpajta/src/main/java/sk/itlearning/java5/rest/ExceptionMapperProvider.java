package sk.itlearning.java5.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		if (exception instanceof IllegalArgumentException) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.serverError().build();
	}

}
