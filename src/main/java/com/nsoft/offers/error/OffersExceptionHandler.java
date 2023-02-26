package com.nsoft.offers.error;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OffersExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(OffersExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<HashMap<String, String>>  handleException(Exception ex) {
		LOGGER.error("An error occurred: {}, cause: {}, stackTrace: {} ", ex.getMessage(), ex.getCause(), ex.getStackTrace());

	    var errorResponse = new HashMap<String, String>();
	    errorResponse.put("message", ex.getMessage());
	    errorResponse.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	@ExceptionHandler(OffersException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<HashMap<String, String>> handleOffersException(OffersException ex) {
		LOGGER.error("An error occurred: {}, cause: {}, stackTrace: {} ", ex.getMessage(), ex.getCause(), ex.getStackTrace());
	
	    var errorResponse = new HashMap<String, String>();
	    errorResponse.put("message", ex.getMessage());
	    errorResponse.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

}
