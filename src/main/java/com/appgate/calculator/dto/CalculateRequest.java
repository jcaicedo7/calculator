package com.appgate.calculator.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CalculateRequest {
    @NotBlank(message = "La operacion es requerida")
    @NotNull(message = "La operacion es requerida")
    @Size(min = 5, max = 20, message = "La operaciones un dato especifico segun especificacion")
    private String operation;
    
    @NotNull
    private boolean isAddResult;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean isAddResult() {
		return isAddResult;
	}
	
	public boolean getAddResult() {
		return isAddResult;
	}

	public void setAddResult(boolean isAddResult) {
		this.isAddResult = isAddResult;
	}
    
    
}
