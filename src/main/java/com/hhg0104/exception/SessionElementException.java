package com.hhg0104.exception;

import org.springframework.http.HttpStatus;

public class SessionElementException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode = HttpStatus.BAD_REQUEST;

	public SessionElementException(String message) {
		super(message);
	}

	public SessionElementException(String message, HttpStatus errorCode) {
		super(message);
		this.statusCode = errorCode;
	}

	public SessionElementException(String message, Throwable exception, HttpStatus errorCode) {
		super(message, exception);
		this.statusCode = errorCode;
	}

	public HttpStatus getCode() {
		return statusCode;
	}
}
