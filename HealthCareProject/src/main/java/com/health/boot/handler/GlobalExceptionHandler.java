package com.health.boot.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.health.boot.exceptions.UserAlreadyExistException;
import com.health.boot.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(UserNotFoundException ux){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "Not Found");
		errors.put("Message", ux.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(UserAlreadyExistException ux){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "Not Found");
		errors.put("Message", ux.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		
	}

}
