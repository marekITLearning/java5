package sk.itlearning.java5.rest.app;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse {

	@Schema(description = "Simple error code")
	private String code;

	@Schema(description = "HTTP response status")
	private int status;

	@Schema(description = "Human readable error message")
	private String message;

	private ErrorResponse() {
	}

	public static Response build(ErrorCodes errorCode, String message) {
		ErrorResponse er = new ErrorResponse();
		er.status = errorCode.getStatusCode();
		er.code = errorCode.name();
		er.message = message;
		return Response.status(er.status).entity(er.toJson()).build();
	}

	private String toJson() {
		return new Gson().toJson(this);
	}

	public String getCode() {
		return code;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
