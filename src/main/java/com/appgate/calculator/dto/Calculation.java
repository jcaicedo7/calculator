package com.appgate.calculator.dto;

import java.io.Serializable;

public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L;
	private String values;
	private String operation;
	private Double result;
	
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
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
}
