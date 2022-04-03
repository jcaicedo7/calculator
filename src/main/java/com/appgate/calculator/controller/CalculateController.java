package com.appgate.calculator.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.calculator.dto.CalculateRequest;
import com.appgate.calculator.dto.Calculation;
import com.appgate.calculator.dto.OperatorRequest;
import com.appgate.calculator.exception.CalculateException;
import com.appgate.calculator.facade.ICalculateFacade;

@RestController
@RequestMapping("/calculator")
@Validated
public class CalculateController {
    @Autowired
    ICalculateFacade serviceFacade;
    
	@GetMapping(value = "/getid", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getId(){
	    String id = serviceFacade.getId();
	    ResponseEntity<String> response = new ResponseEntity<String>(id, HttpStatus.OK);
		return response;
	}	

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<?> add(@RequestHeader("id") String id,@Valid @RequestBody OperatorRequest operator) {    	
		ResponseEntity<?> response = null;
		try {
			String message = serviceFacade.add(id,operator.getValue());
		    response = new ResponseEntity<String>(message, HttpStatus.OK);
		} 
		catch (Exception exc) {
		    Map<String, Object> result = new HashMap<>();
		    result.put("mensaje", exc.getMessage());
		    response = new ResponseEntity<Map<String, Object>>(result, HttpStatus.NOT_FOUND);
		}
		return response;
    }	
    
    @PostMapping("/calculate")
	public ResponseEntity<?> calculate(@RequestHeader("id") String id,@Valid @RequestBody CalculateRequest request) {    	
		ResponseEntity<?> response = null;
		try {
			Calculation calculation = serviceFacade.calculate(id, request);
		    response = new ResponseEntity<Calculation>(calculation, HttpStatus.OK);
		} 
		catch(CalculateException exc) {
		    Map<String, Object> result = new HashMap<>();
		    result.put("mensaje", exc.getMessage());
		    response = new ResponseEntity<Map<String, Object>>(result, HttpStatus.NOT_FOUND);
		}
		return response;
    }    
}
