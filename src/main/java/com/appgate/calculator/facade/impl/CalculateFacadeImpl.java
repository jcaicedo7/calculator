package com.appgate.calculator.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.calculator.dto.CalculateRequest;
import com.appgate.calculator.dto.Calculation;
import com.appgate.calculator.exception.CalculateException;
import com.appgate.calculator.facade.ICalculateFacade;
import com.appgate.calculator.service.ICalculateService;

import javax.ws.rs.NotFoundException;
import java.util.UUID;

@Service
public class CalculateFacadeImpl implements ICalculateFacade{
	
	@Autowired
	private ICalculateService service;
	
	public String getId() {
		String id = UUID.randomUUID().toString();
		service.save(id);
		return id;
	}
	
	public String add(String id, Double value) throws CalculateException{
		String response = null;
		try {
			String currentlyValues = service.findById(id);
			String newValues = currentlyValues + "," + value;
			service.update(id, newValues);
			response = value + " agregado";
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;
	}
	
	public Calculation calculate(String id,CalculateRequest request) throws CalculateException{
		Calculation calculation = null;
		String operation = request .getOperation();
		try {
			String currentlyValues = service.findById(id);
			calculation = new Calculation();
			calculation.setValues(currentlyValues);
			System.out.println("--------" +operation);
			/*
			if(request.isAddResult()) {
				service.clear()
			}
			*/
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return calculation;
	}
	
	public String clear(String id) throws CalculateException{
		return null;
	}
	
	public String remove(String id) throws CalculateException{
		return null;		
	}

}
