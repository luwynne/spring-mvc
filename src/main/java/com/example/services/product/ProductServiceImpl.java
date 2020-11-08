package com.example.services.product;

import java.util.List;
import java.util.Optional;

import com.example.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
	ProductDAO productDAO;

    @Override
    public List<Product> listAll() {
        return (List<Product>) productDAO.findAll();
    }

    @Override
    public Optional<Product> getById(Integer id) {
    	return productDAO.findById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
    	return productDAO.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
    	productDAO.deleteById(id);
    }
}
