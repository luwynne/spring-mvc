package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Product;

public interface ProductDAO extends CrudRepository<Product, Integer>{

}
