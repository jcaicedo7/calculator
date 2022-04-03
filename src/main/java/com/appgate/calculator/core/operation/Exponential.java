package com.appgate.calculator.core.operation;

import java.util.List;
import com.appgate.calculator.core.IOperation;

/**
 * Clase implementan el calculo para realizar la operacion matematica de aplicar potencia 
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */

public class Exponential implements IOperation {
	
	public Double calculate(List<Double> list){
		double exponent = (double)1 / list.get(0);
		double base = Math.pow(list.get(0),exponent);
		for(Double value : list) {
			base = Math.pow(base,value);
		}		
		double result = (double) Math.round(base);
		return result;
	} 
	

}
