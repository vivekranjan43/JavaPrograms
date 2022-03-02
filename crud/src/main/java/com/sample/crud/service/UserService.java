package com.sample.crud.service;

import java.util.List;

import com.sample.crud.model.User;


public interface UserService {
	
  User addUser(User user);
  User getUserById(int userId);
  void updateUser(User user);
  void deleteUserById(int userId);
  List<User> getAllUsers();
}