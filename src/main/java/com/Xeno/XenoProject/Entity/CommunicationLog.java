package com.Xeno.XenoProject.Entity;


import jakarta.persistence.*;

@Entity
public class CommunicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;
    
    private String message;

    @Column(nullable = false)
    private String status = "SENT";
    
    public CommunicationLog() { }

    public CommunicationLog(Customer customer, Campaign campaign, String message, String status) {
        this.customer = customer;
        this.campaign = campaign;
        this.message = message;
        this.status = status;
    }
    
    // Getters and Setters
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

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
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
        return "CommunicationLog [id=" + id + ", customer=" + customer + ", campaign=" + campaign + 
                ", message=" + message + ", status=" + status + "]";
    }
}
