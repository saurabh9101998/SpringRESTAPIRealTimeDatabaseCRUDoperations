package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResposnse> handleException(Exception exc){
		
		CustomerErrorResposnse errorResposnse = new CustomerErrorResposnse();
		
		errorResposnse.setMessage(exc.getMessage());
		errorResposnse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResposnse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResposnse>(errorResposnse,HttpStatus.BAD_REQUEST);
	}

}
