package com.appgate.calculator.core.operation;

import java.util.List;

import com.appgate.calculator.core.IOperation;

public class Multiplication implements IOperation {
		
	public Double calculate(List<Double> list){
		Double result = 1.0;
		for(Double value : list) {
			result *= value;
		}		
		return result;
	} 
}
