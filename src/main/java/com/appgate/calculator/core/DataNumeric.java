package com.appgate.calculator.core;

import java.util.Arrays;
import java.util.List;

import com.appgate.calculator.exception.CalculateException;


public class DataNumeric {
	public final static String SEPARATOR = ",";

	private String values = null;
	
	public DataNumeric(String values){
		this.values = values;
	}
	
	public void isValidNumber() throws CalculateException{
		if(values == null){
			throw new CalculateException("Falta operandos para realiza calculo");
		}
		else if(values.equals("")) {
			throw new CalculateException("Falta operandos para realiza calculo");
		}
		else {
			String[] valuesString = values.split(SEPARATOR);
			boolean isMajorOne = (valuesString.length > 1) ? true : false;
			if(!isMajorOne) {
				throw new CalculateException("Falta operandos, requiere por lo menos dos operandos");				
			}
		}
	} 
	
	public List<Double> getListValues() throws CalculateException{
		String[] valuesString = values.split(SEPARATOR);
		Double[] valuesNumeric = new Double[valuesString.length]; 
		try {
			for(int i=0;i<valuesString.length;i++) {
				double numeric = Double.parseDouble(valuesString[i]);
				valuesNumeric[i] = numeric;
			}
		}
		catch(NumberFormatException exc) {
			throw new CalculateException("Dato invalido",exc.getCause());
		}
		List<Double> list = Arrays.asList(valuesNumeric);
		return list;
	}
	
	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}
	
	
}
