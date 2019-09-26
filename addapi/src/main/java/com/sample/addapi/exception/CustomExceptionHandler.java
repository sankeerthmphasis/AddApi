package com.sample.addapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourseNotFoundException(ResourceNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), new Date(), "Value Empty");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleInvalidInputExceptionException(InvalidInputException ex,
			WebRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), new Date(), request.getDescription(true));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), new Date(), request.getDescription(true));
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
