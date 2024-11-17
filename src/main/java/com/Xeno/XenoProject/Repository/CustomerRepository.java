package com.Xeno.XenoProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Xeno.XenoProject.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByTotalSpendsGreaterThan(Double totalSpends);
	
	List<Customer> findByTotalSpendsGreaterThanEqual(Double totalSpends);
	
	List<Customer> findByTotalSpendsLessThan(Double totalSpends);
		
	List<Customer> findByTotalSpendsLessThanEqual(Double totalSpends);
	
	List<Customer> findByTotalSpends(Double totalSpends);
}
