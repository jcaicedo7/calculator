package com.appgate.calculator.exception;

public class CalculateException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CalculateException(String message) {
		super(message);
	}
	
	public CalculateException(String message, Throwable t) {
		super(message, t);
	}
}
