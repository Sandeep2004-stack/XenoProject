package com.Xeno.XenoProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.Entity.CommunicationLog;
import com.Xeno.XenoProject.Repository.CommunicationLogRepository;

@Service
public class CommunicationLogService {

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    // Save communication logs
    public void saveLogs(List<CommunicationLog> logs) {
        communicationLogRepository.saveAll(logs);
    }

    // Get all communication logs
    public List<CommunicationLog> getLogsByCampaign(Long campaignId) {
        return communicationLogRepository.findByCampaignId(campaignId);
    }

    // Update delivery status for a log
    public void updateLogStatus(Long logId, String status) {
        CommunicationLog log = communicationLogRepository.findById(logId).orElse(null);
        if (log != null) {
            log.setStatus(status);
            communicationLogRepository.save(log);
        }
    }
}


