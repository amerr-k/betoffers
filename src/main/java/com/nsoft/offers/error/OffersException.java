package com.nsoft.offers.error;

public class OffersException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public OffersException(String message) {
		super(message);
	}
	
	public OffersException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
