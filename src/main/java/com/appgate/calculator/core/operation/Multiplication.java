package com.appgate.calculator.core.operation;

import java.util.List;

import com.appgate.calculator.core.IOperation;
/**
 * Clase implementan el calculo para realizaar la operacion matematica de multiplicacion   
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */

public class Multiplication implements IOperation {
		
	public Double calculate(List<Double> list){
		Double result = 1.0;
		for(Double value : list) {
			result *= value;
		}		
		return result;
	} 
}
