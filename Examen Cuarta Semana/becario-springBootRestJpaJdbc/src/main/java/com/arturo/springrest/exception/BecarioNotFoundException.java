package com.arturo.springrest.exception;

public class BecarioNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BecarioNotFoundException(String message) {
        super(message);
    }
}
