package com.capitole.scm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capitole.scm.model.ErrorMessage;
import com.capitole.scm.util.Constant;


@ControllerAdvice
public class ControllerExceptionHandler {
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<ErrorMessage> handleException(ConstraintViolationException exception,HttpServletRequest request) {
		String message = exception.getLocalizedMessage();
		ErrorMessage error = new ErrorMessage(400, message);
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ConversionFailedException.class })
    public ResponseEntity<ErrorMessage> handleException(ConversionFailedException exception,HttpServletRequest request) {
    	if(request.getRequestURI().equals(Constant.SERVICE_TARIFF_QUERY)) {
			ErrorMessage error = new ErrorMessage(400, Constant.VALID_DATE_MESSAGE);
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    	}
    	else {
			String message = exception.getLocalizedMessage();
			ErrorMessage error = new ErrorMessage(400, message);
			return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    	}
    }

}
