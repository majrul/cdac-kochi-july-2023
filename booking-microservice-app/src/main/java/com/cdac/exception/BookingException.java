package com.cdac.exception;

public class BookingException extends RuntimeException {

	public BookingException() {
		super();
	}

	public BookingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookingException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookingException(String message) {
		super(message);
	}

	public BookingException(Throwable cause) {
		super(cause);
	}

	
}
