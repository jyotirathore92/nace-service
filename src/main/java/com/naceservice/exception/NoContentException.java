package com.naceservice.exception;

import java.util.ArrayList;

/**
 * Custom defined Exception class with parameterized constructors for different parameter types
 *
 * @author Jyoti
 */

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final List<ObjectError> errors = new ArrayList<>();

	public NoContentException(String exception) {
        super(exception);
    }
	
	public List<ObjectError> getErrors() {
		return errors;
	}

}
