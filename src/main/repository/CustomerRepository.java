package com.Xeno.XenoProject.XenoProject.CustomerRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Xeno.XenoProject.XenoProject.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
