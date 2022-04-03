package com.appgate.calculator.core.operation;

import java.util.List;
import com.appgate.calculator.core.IOperation;

/**
 * Clase implementan el calculo para realizar la operacion matematica de adicion (suma)  
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */
public class Addition implements IOperation {
	
	public Addition() {
		super();
	}
	
	public Double calculate(List<Double> list){
		Double result = 0.0;
		for(Double value : list) {
			result += value;
		}		
		return result;
	} 

}
