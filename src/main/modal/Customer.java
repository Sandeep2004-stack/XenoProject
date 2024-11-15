package com.Xeno.XenoProject.XenoProject.customer;

import com.Xeno.XenoProject.XenoProject.order.Order;  // Correct import

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @Column(name = "total_spends")
    private Double totalSpends;
    private Integer visits;
    @Column(name = "last_visit")
    @Temporal(TemporalType.DATE)
    private Date lastVisit;


    @OneToMany(mappedBy = "customer")
    private List<Order> orders;  
    
    public Customer() {}

    public Customer(String name, String email, Double totalSpends, Integer visits, Date lastVisit, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.totalSpends = totalSpends;
        this.visits = visits;
        this.lastVisit = lastVisit;
        this.orders = orders;
    }

   
}
