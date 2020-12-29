package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends RuntimeException{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleEmployee(Exception e){
		return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
