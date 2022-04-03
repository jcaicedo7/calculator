package com.appgate.calculator.facade;

import com.appgate.calculator.exception.CalculateException;

public interface IIdentifyFacade {
	public String create();
	public String delete(String id) throws CalculateException;
}
