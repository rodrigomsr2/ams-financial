package br.com.mesttra.financial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = -2674269313864511014L;
	
	private static final String ERROR_MESSAGE = getErrorMessage();
	
	public ResourceNotFoundException() {
		this(HttpStatus.NOT_FOUND);
	}
	
	public ResourceNotFoundException(HttpStatus status) {
		super(status, ERROR_MESSAGE);
	}
	
	private static String getErrorMessage() {
		return "The resource was not found.";
	}

}
