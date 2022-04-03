package com.appgate.calculator.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.calculator.core.DataNumeric;
import com.appgate.calculator.core.FactoryOperation;
import com.appgate.calculator.core.IOperation;
import com.appgate.calculator.dto.CalculateRequest;
import com.appgate.calculator.dto.Calculation;
import com.appgate.calculator.exception.CalculateException;
import com.appgate.calculator.facade.ICalculateFacade;
import com.appgate.calculator.service.ICalculateService;

import javax.ws.rs.NotFoundException;

import java.util.List;

@Service
public class CalculateFacadeImpl implements ICalculateFacade{
	
	@Autowired
	private ICalculateService service;
	
	
	public String query(String id) throws CalculateException{
		String response = null;
		try {
			response = service.findById(id);
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;
	}	
	
	public String add(String id, Double value) throws CalculateException{
		String response = null;
		String newValues = null;
		try {
			String currentlyValues = service.findById(id);
			if(currentlyValues.equals("")) {
				newValues = value.toString();	
			}
			else {
				newValues = currentlyValues + "," + value;
			}
			service.update(id, newValues);
			response = "Numeros agreados " + newValues ;
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;
	}
	
	public Calculation calculate(String id,CalculateRequest request) throws CalculateException{
		Calculation calculation = null;
		String nameOperation = request .getOperation();
		try {
			String values = service.findById(id);
			calculation = processCalculate(values,nameOperation);
			if(request.isAddResult()) {
				clear(id);
				add(id,calculation.getResult());
			}			
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return calculation;
	}
	
	public String clear(String id) throws CalculateException{
		String response = null;
		try {
			service.update(id,"");
			response = "Se eliminaron todos los datos agregados";
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;
	}
	
	public String remove(String id,Double value) throws CalculateException{
		String response = null;
		try {
			String currentlyValues = service.findById(id);
			String valueDelete = value.toString() + ",";
			String newvalues = currentlyValues.replace(valueDelete,"");
			service.update(id,newvalues);
			if(newvalues.equals(currentlyValues)) {
				response = "Numero no encontrado";
			}
			else {
				response = "Actualizado " + newvalues ;
			}
		}
		catch(NotFoundException exc) {
			throw new CalculateException(exc.getMessage());
		}
		return response;		
	}

	private Calculation processCalculate(String values, String nameOperation) throws CalculateException{
		Calculation calculation = new Calculation();
    	try {
    		DataNumeric dataNumeric = new DataNumeric(values);
    		dataNumeric.isValidNumber();
    		List<Double> listValues = dataNumeric.getListValues();
    		
        	IOperation operation = FactoryOperation.creatOperation(nameOperation);
	    	Double result = operation.calculate(listValues);
	    	
			calculation.setValues(values);
			calculation.setOperation(nameOperation);
			calculation.setResult(result);
    	}
    	catch(Exception exc) {
			throw new CalculateException(exc.getMessage());
    	}
		return calculation;
	}

}
