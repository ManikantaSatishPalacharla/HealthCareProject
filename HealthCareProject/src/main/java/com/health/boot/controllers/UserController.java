package com.health.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.boot.entities.User;
import com.health.boot.exceptions.UserAlreadyExistException;
import com.health.boot.services.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	IUserService uService;
	
	@PostMapping("/login")
	public ResponseEntity<String> signIn(@RequestBody String username, @RequestBody String password){
		
		User u = uService.validateUser(username, password);
		return new ResponseEntity<String>("Logged In",HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/signUp")
	public ResponseEntity signUp(@RequestBody User user){
		

		User u = uService.addUser(user);
		if(u==null)
			throw new UserAlreadyExistException("Already an Account Exist with this user name");
		return new ResponseEntity<String>("Sign Up Sucessfull",HttpStatus.ACCEPTED);

	}
	
	

}
