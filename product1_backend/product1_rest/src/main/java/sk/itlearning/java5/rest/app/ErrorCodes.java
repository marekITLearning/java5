package sk.itlearning.java5.rest.app;

public enum ErrorCodes {
	BackendServerError(500),
	BadDataOrArguments(400),
	Forbidden(403),
	NotFoundException(404),
	NotAllowedException(405),
	RightNotFoundException(403),
	ServiceUnavailable(503),
	TooManyRequests(429),
	Unauthorized(401);
	
	private int statusCode;
	
	ErrorCodes(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}

}
