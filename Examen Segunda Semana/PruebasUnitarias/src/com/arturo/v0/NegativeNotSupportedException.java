package com.arturo.v0;

public class NegativeNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NegativeNotSupportedException(String message) {
		super(message);
	}

}
