package com.appgate.calculator.exception;

public class FactoryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FactoryException(String message) {
		super(message);
	}
	
	public FactoryException(String message, Throwable t) {
		super(message, t);
	}

}
