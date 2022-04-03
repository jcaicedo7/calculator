package com.appgate.calculator.dto;

import java.io.Serializable;

public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L;
	private String values;
	private String operation;
	private String result;
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}	
}
