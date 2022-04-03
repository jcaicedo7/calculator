package com.appgate.calculator.core.operation;

import java.util.List;

import com.appgate.calculator.core.IOperation;

public class Sustraction implements IOperation {
	
	public Double calculate(List<Double> list) {
		Double result = list.get(0) * 2;
		for(Double value : list) {
			result -= value;
		}		
		return result;
	} 

}
