package com.usermanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException) {

		HashMap<String, String> responseMap = new HashMap<>();
		responseMap.put("Message", userNotFoundException.getMessage());
		return responseMap;
	}

}
