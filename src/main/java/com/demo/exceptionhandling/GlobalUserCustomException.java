package com.demo.exceptionhandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalUserCustomException {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {

		UserApiError userApiError = new UserApiError(userNotFoundException.getMessage(),
				userNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(userApiError, HttpStatus.NOT_FOUND);
	}
	
}
