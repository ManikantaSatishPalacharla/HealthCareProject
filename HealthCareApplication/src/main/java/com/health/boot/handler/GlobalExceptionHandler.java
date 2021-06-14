package com.health.boot.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.health.boot.exceptions.AllreadyDiagnosticTestExistException;
import com.health.boot.exceptions.DiagnosticCenterAllReadyExistsException;
import com.health.boot.exceptions.DiagnosticCenterNotFoundException;
import com.health.boot.exceptions.DiagnosticTestNotFoundException;
import com.health.boot.exceptions.UserAlreadyExistException;
import com.health.boot.exceptions.UserIdPasswordInvalidException;
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
		
		errors.put("Error", "User Already Exist");
		errors.put("Message", ux.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserIdPasswordInvalidException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(UserIdPasswordInvalidException uv){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "Password is not matching");
		errors.put("Message", uv.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AllreadyDiagnosticTestExistException.class)
	public ResponseEntity<Object> handleDiagnosticTestException(AllreadyDiagnosticTestExistException ad){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "There is allready a DiagnosticTest");
		errors.put("Message", ad.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DiagnosticTestNotFoundException.class)
	public ResponseEntity<Object> handleDiagnosticTestException(DiagnosticTestNotFoundException dn){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "There is No DiagnosticTest Found");
		errors.put("Message", dn.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DiagnosticCenterNotFoundException.class)
	public ResponseEntity<Object> handleDiagnosticCenterException(DiagnosticCenterNotFoundException dc){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "There is No DiagnosticCenter Found");
		errors.put("Message", dc.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DiagnosticCenterAllReadyExistsException.class)
	public ResponseEntity<Object> handleDiagnosticCenterException(DiagnosticCenterAllReadyExistsException de){
		
		Map<String,Object> errors = new LinkedHashMap<>();
		
		errors.put("Error", "There is Allready a DiagnosticCenter");
		errors.put("Message", de.getMessage());
		errors.put("Time", LocalDateTime.now());
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		
	}
	

}
