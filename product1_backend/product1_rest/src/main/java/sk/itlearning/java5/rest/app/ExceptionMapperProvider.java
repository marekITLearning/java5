package sk.itlearning.java5.rest.app;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Throwable> {

	private static final Logger logger = LogManager.getLogger(ExceptionMapperProvider.class);

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(Throwable exception) {
		
		if (exception instanceof NotFoundException) {
			logger.fatal(exception);
			return ErrorResponse.build(ErrorCodes.NotFoundException);	
		}
		
		exception.printStackTrace();

		return ErrorResponse.build(ErrorCodes.BackendServerError);
	}

}
