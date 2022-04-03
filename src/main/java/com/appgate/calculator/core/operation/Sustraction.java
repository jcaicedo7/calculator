package com.appgate.calculator.core.operation;

import java.util.List;

import com.appgate.calculator.core.IOperation;

/**
 * Clase implementan el calculo para realizaar la operacion matematica de resta o sustraccion
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */

public class Sustraction implements IOperation {
	
	public Double calculate(List<Double> list) {
		Double result = list.get(0) * 2;
		for(Double value : list) {
			result -= value;
		}		
		return result;
	} 

}
