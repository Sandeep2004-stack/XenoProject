package com.Xeno.XenoProject.XenoProject.communicationlog;

import com.Xeno.XenoProject.XenoProject.customer.Customer; // Import Customer entity
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CommunicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; 

    private String message;

    @Column(nullable = false)
    private String status = "SENT";
    
    public CommunicationLog() { }

    public CommunicationLog(Customer customer, String message, String status) {
        this.customer = customer;
        this.message = message;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CommunicationLog [id=" + id + ", customer=" + customer + ", message=" + message + ", status=" + status + "]";
    }
}
