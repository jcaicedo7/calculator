package com.appgate.calculator.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class OperatorRequest {
	@NotNull(message = "El valor es requerido")
	@DecimalMin(value="1.0", message = "El numero no puede ser menor a 1") 
	@DecimalMax(value="1000.0", message = "El numero no puede ser mayor a 1000") 
	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	} 	 
}
