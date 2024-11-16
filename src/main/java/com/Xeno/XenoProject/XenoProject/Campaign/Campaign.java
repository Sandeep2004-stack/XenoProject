package com.Xeno.XenoProject.XenoProject.Campaign;

import java.time.LocalDateTime;
import java.util.List;

import com.Xeno.XenoProject.XenoProject.communicationlog.CommunicationLog;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String message;

    private LocalDateTime createdAt; 

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommunicationLog> communicationLogs;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CommunicationLog> getCommunicationLogs() {
        return communicationLogs;
    }

    public void setCommunicationLogs(List<CommunicationLog> communicationLogs) {
        this.communicationLogs = communicationLogs;
    }

    // Default Constructor
    public Campaign() {}

    // Parameterized Constructor
    public Campaign(String name, String message, LocalDateTime createdAt, List<CommunicationLog> communicationLogs) {
        this.name = name;
        this.message = message;
        this.createdAt = createdAt;
        this.communicationLogs = communicationLogs;
    }
}
