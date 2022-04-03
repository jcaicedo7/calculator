package com.appgate.calculator.core.operation;

import java.util.List;

import com.appgate.calculator.core.IOperation;
import com.appgate.calculator.exception.CalculateException;

/**
 * Clase implementan el calculo para realizar la operacion matematica de division   
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */

public class Division implements IOperation {
	
	public Double calculate(List<Double> list) throws CalculateException{
		Double result = list.get(0) * list.get(0);
		for(Double value : list) {
			if(value.doubleValue() == 0) {
				throw new CalculateException("No se puede dividir entre 0");
			}
			else {
				result /= value;
			}
		}		
		return result;
	} 

}
