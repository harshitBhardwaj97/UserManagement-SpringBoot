package com.usermanagement.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();

	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
