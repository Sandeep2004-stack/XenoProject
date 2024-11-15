package com.Xeno.XenoProject.XenoProject.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Xeno.XenoProject.XenoProject.CustomerRepository.CustomerRepository;
import com.Xeno.XenoProject.XenoProject.customer.Customer;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
    	System.out.print(customer);
    	
          return customerRepository.save(customer);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomers() {
    	List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
