package com.Xeno.XenoProject.XenoProject.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Xeno.XenoProject.XenoProject.CustomerRepository.CustomerRepository;
import com.Xeno.XenoProject.XenoProject.CustomerService.CustomerService;
import com.Xeno.XenoProject.XenoProject.customer.Customer;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
          return customerRepository.save(customer);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomers() {
    	List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    @GetMapping("/customer/filter")
    public ResponseEntity<List<Customer>> getCustomerByCondition(@RequestParam String condition, @RequestParam Double totalSpends ) {
    	Double value = (double) totalSpends;
    	System.out.println(condition);
    	List<Customer> customers = customerService.getCustomerByCondition(condition, value);   
    	 return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
