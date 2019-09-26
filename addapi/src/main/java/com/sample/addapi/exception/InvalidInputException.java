package com.sample.addapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException{
	
	
	private static final long serialVersionUID = 8427283188509440871L;

	public InvalidInputException(){
		super();
		
	}
	
	public InvalidInputException(String message) {
		super(message);
		
	}

}
