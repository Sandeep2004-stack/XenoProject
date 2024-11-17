package com.Xeno.XenoProject.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.Entity.Campaign;
import com.Xeno.XenoProject.Repository.CampaignRepository;
import com.Xeno.XenoProject.Repository.CommunicationLogRepository;


@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    // Create a new campaign
    public Campaign createCampaign(String name, String message, String createdAt) {
        LocalDateTime createdAtDateTime = LocalDateTime.parse(createdAt, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Campaign campaign = new Campaign();
        campaign.setName(name);
        campaign.setMessage(message);
        campaign.setCreatedAt(createdAtDateTime);
        return campaignRepository.save(campaign);
    }

    // Retrieve all campaigns sorted by creation date
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAllByOrderByCreatedAtDesc();
    }

    // Generate campaign statistics
    public Map<String, Integer> getCampaignStats(Long campaignId) {
        int totalLogs = communicationLogRepository.countByCampaign_Id(campaignId);
        int sentLogs = communicationLogRepository.countByCampaign_IdAndStatus(campaignId, "SENT");
        int failedLogs = totalLogs - sentLogs;

        return Map.of("total", totalLogs, "sent", sentLogs, "failed", failedLogs);
    }
}
