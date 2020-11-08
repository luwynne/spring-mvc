package com.example.services.customer;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDAO;
import com.example.dao.ProductDAO;
import com.example.domain.Customer;
import com.example.domain.Product;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	CustomerDAO customerDAO;

    @Override
    public List<Customer> listAll() {
    	return (List<Customer>) customerDAO.findAll();
    }

    @Override
    public Optional<Customer> getById(Integer id) {
    	return customerDAO.findById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return customerDAO.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
    	customerDAO.deleteById(id);
    }
}
