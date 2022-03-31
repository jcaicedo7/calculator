package com.appgate.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

	
	@GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getId(){
		ResponseEntity<?> response = null;	
		return response;
	}
}
