package com.appgate.calculator.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.calculator.facade.ICalculateFacade;
import com.appgate.calculator.facade.IIdentifyFacade;

@RestController
@RequestMapping("/identify")
@Validated
public class IdentifyController {
    @Autowired
    IIdentifyFacade serviceFacade;
    
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(){
	    String id = serviceFacade.create();
	    ResponseEntity<String> response = new ResponseEntity<String>(id, HttpStatus.OK);
		return response;
	}
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestHeader("id") String id) {    	
		ResponseEntity<?> response = null;
		try {
			String message = serviceFacade.delete(id);
		    response = new ResponseEntity<String>(message, HttpStatus.OK);
		} 
		catch (Exception exc) {
		    Map<String, Object> result = new HashMap<>();
		    result.put("mensaje", exc.getMessage());
		    response = new ResponseEntity<Map<String, Object>>(result, HttpStatus.NOT_FOUND);
		}
		return response;
    }    
}