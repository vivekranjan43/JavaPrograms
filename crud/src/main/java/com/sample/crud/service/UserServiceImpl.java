package com.sample.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sample.crud.model.User;
import com.sample.crud.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository repository;
  @Override
  public User addUser(User user) {
    return repository.save(user);
  }
  @Override
  public User getUserById(int userId) {
    return repository.findById(userId).get();
  }
  @Override
  public List<User> getAllUsers(){
    return repository.findAll();
  }
  
  @Override
  public void updateUser(User user) {
    // check if the user with the passed id exists or not
    User userDB = repository.findById(user.getUserId()).orElseThrow(null);
    // If user exists then updated
    repository.save(user);
  }
  
  @Override
  public void deleteUserById(int userId) {
    try {
      repository.deleteById(userId);  
    }catch(DataAccessException ex){
      throw new RuntimeException(ex.getMessage());
    }
  }
}