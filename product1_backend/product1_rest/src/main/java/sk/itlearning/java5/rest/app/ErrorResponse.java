package sk.itlearning.java5.rest.app;

import com.google.gson.Gson;

import jakarta.ws.rs.core.Response;

public class ErrorResponse {

	private String code;

	private int status;

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
