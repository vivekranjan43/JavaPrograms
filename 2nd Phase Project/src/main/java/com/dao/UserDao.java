package com.dao;

import com.dto.User;

public interface UserDao {
	
	public void addUser(User user);
	public boolean validateUser(User user);
}
