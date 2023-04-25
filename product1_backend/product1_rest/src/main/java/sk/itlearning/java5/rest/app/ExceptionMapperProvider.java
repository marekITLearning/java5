package sk.itlearning.java5.rest.app;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Throwable> {

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(Throwable exception) {

		if (exception instanceof IllegalArgumentException) {
			return ErrorResponse.build(ErrorCodes.BadDataOrArguments, exception.getLocalizedMessage());
		}

		exception.printStackTrace();

		return ErrorResponse.build(ErrorCodes.BackendServerError, "Unknown error");
	}

}
