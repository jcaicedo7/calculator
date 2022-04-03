package com.appgate.calculator.facade;

import com.appgate.calculator.dto.CalculateRequest;
import com.appgate.calculator.dto.Calculation;
import com.appgate.calculator.exception.CalculateException;

public interface ICalculateFacade {
	public String query(String id) throws CalculateException;
	public String add(String id,Double value) throws CalculateException;
	public Calculation calculate(String id,CalculateRequest request) throws CalculateException;
	public String clear(String id) throws CalculateException;
	public String remove(String id,Double value) throws CalculateException;
}
