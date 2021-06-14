package com.health.boot.service;

import com.health.boot.entities.User;

public interface IUserService {
	
	User validateUser(String username, String password) throws RuntimeException;
	public User addUser(User user);
	public User removeUser(User user);

}