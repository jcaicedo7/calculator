package com.appgate.calculator.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appgate.calculator.dto.ErrorMessage;

/**
* Clase para capturar las exepciones lanzadas al aplicar la validación de entradas de valores 
* y emitirlas al cliente
* 
* @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
* 
*/


@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException e) {
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		List<String> messages = new ArrayList<String>();
		for (ObjectError error : errors) {
			if (error instanceof FieldError) {
				FieldError fieldError = (FieldError) error;
				messages.add(fieldError.getField() + " " + fieldError.getRejectedValue() + " " + error.getDefaultMessage());
			} 
			else {
				messages.add(error.toString());
			}
		}
		String messageResult = messages.toString();
		ErrorMessage error = new ErrorMessage(400, messageResult);
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}	
}

