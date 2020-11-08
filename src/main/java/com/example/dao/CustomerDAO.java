package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{

}
