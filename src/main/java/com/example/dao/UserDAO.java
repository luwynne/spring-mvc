package com.example.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String userName);

}
