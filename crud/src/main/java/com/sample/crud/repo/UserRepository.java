package com.sample.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.crud.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
