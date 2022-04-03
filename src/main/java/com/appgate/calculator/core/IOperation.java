package com.appgate.calculator.core;

import java.util.List;

import com.appgate.calculator.exception.CalculateException;

/**
 * Interface a traves de la cual se generaliza la operacion de calculo matematico
 * mediante la declaracion del metodo calculate
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */
public interface IOperation {
	public Double calculate(List<Double> list) throws CalculateException;
}
