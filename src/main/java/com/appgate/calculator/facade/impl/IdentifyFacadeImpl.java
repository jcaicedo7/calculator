package com.appgate.calculator.facade.impl;

import java.util.UUID;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.calculator.exception.CalculateException;
import com.appgate.calculator.facade.IIdentifyFacade;
import com.appgate.calculator.service.ICalculateService;

@Service
public class IdentifyFacadeImpl implements IIdentifyFacade{
	@Autowired
	private ICalculateService service;
	
	public String create() {
		String id = UUID.randomUUID().toString();
		service.save(id);
		return id;
	}
	
	public String delete(String id) throws CalculateException{
		String response = null;
		try {
			service.delete(id);
			response = "Identificador eliminado";
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;		
	}	
}
