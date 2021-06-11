package com.health.boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.boot.entities.User;
import com.health.boot.exceptions.UserNotFoundException;
import com.health.boot.repo.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	
	UserRepository ur;

	@Override
	public User validateUser(String username, String password) throws RuntimeException {
		
		Optional<User> u = ur.findById(username);
		if(u.isPresent())
			return u.get();
		throw new UserNotFoundException("User Not Found. You can SignUp");

	}

	@Override
	public User addUser(User user) {

		boolean u = ur.existsById(user.getUsername());
		System.out.println(u);
		if(u) 
			return null;
		User uu = ur.save(user);

		return uu;
	
	}

	@Override
	public User removeUser(User user) {
		Optional<User> u = ur.findById(user.getUsername());
		if(!u.isPresent())
			return null;
		ur.delete(user);
		return user;
	}

}
