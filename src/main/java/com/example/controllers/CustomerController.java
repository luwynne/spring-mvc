package com.example.controllers;

import com.example.domain.Customer;
import com.example.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
    	Optional <Customer> customer = customerService.getById(id);
    	
    	if(customer.isPresent()) {
    		model.addAttribute("customer", customer.get());
    	}
        
        return "customer/show";
    }

    @RequestMapping("customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customer_form";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String createCustomer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/"+savedCustomer.getId();
        
    }

    @RequestMapping("customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customer_form";
    }

    @RequestMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customers";
    }
}
