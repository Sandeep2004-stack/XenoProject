package com.Xeno.XenoProject.XenoProject.CustomerService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.XenoProject.CustomerRepository.CustomerRepository;
import com.Xeno.XenoProject.XenoProject.customer.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomerByCondition(String condition,Double totalSpends) {
    	System.out.println(condition.equals("<"));
    	List<Customer> customers = null;
    	if(condition.equals(">")) {
    		customers = customerRepository.findByTotalSpendsGreaterThan(totalSpends);
    		System.out.println(customers);
    	}
    	else if(condition.equals("<")) {
    		customers = customerRepository.findByTotalSpendsLessThan(totalSpends);
    	}
    	else if(condition.equals(">=")) {
    		customers = customerRepository.findByTotalSpendsGreaterThanEqual(totalSpends);
    	}
    	else if (condition.equals("<=")) {
    		customers = customerRepository.findByTotalSpendsLessThanEqual(totalSpends);
    	}
    	else {
    		customers = customerRepository.findByTotalSpends(totalSpends);
    	}
    	return customers;
    }
}

