package com.Xeno.XenoProject.XenoProject.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.XenoProject.CustomerRepository.CustomerRepository;
import com.Xeno.XenoProject.XenoProject.customer.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // Method to filter customers dynamically based on conditions
    public List<Customer> getCustomersByConditions(Map<String, Object> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> customer = query.from(Customer.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((key, value) -> {
            if (key.equals("totalSpends")) {
                predicates.add(cb.greaterThanOrEqualTo(customer.get("totalSpends"), (Double) value));
            } else if (key.equals("visits")) {
                predicates.add(cb.lessThanOrEqualTo(customer.get("visits"), (Integer) value));
            } else if (key.equals("lastVisit")) {
                predicates.add(cb.lessThan(customer.get("lastVisit"), (Date) value));
            }
        });

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}

