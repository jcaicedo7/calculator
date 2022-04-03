package com.appgate.calculator.core;

import java.util.List;

import com.appgate.calculator.exception.CalculateException;

public interface IOperation {
	public Double calculate(List<Double> list) throws CalculateException;
}
