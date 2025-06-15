package com.study.enumeration;

public enum HttpStatus {

	OK(200, "Request succeeded"), CREATED(201, "Resource created successfully"),
	ACCEPTED(202, "Request accepted but not yet processed"), NO_CONTENT(204, "Request succeeded, no content returned"),
	BAD_REQUEST(400, "Malformed or invalid request"), UNAUTHORIZED(401, "Authentication required"),
	FORBIDDEN(403, "Access is forbidden"), NOT_FOUND(404, "Resource not found"),
	METHOD_NOT_ALLOWED(405, "HTTP method not allowed"), INTERNAL_SERVER_ERROR(500, "Server encountered an error"),
	NOT_IMPLEMENTED(501, "Feature not implemented on server"),
	BAD_GATEWAY(502, "Invalid response from upstream server"),
	SERVICE_UNAVAILABLE(503, "Server temporarily unavailable"){};

	private final int code;
	private final String description;


	HttpStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
