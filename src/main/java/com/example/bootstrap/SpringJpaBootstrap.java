package com.example.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.domain.Product;
import com.example.services.customer.CustomerService;
import com.example.services.product.ProductService;

import antlr.collections.List;
import java.util.*;

import java.math.BigDecimal;


@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //loadProducts();
        //loadCustomers();
    	System.out.println("started");

    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirst_name("Micheal");
        customer1.setFirst_name("Weston");
        customer1.setAddress("1 Main St");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhone_number("305.333.0101");
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirst_name("Fiona");
        customer2.setFirst_name("Glenanne");
        customer2.setAddress("1 Key Biscane Ave");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhone_number("305.323.0233");
        customerService.saveOrUpdate(customer2);

        Customer customer3 = new Customer();
        customer3.setFirst_name("Sam");
        customer3.setFirst_name("Axe");
        customer3.setAddress("1 Little Cuba Road");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhone_number("305.426.9832");
        customerService.saveOrUpdate(customer3);
    }

    public void loadProducts(){

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImage_url("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImage_url("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImage_url("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImage_url("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImage_url("http://example.com/product5");
        productService.saveOrUpdate(product5);

    }
}






















