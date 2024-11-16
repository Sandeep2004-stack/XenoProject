package com.Xeno.XenoProject.XenoProject.CampaignStatsController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Xeno.XenoProject.XenoProject.CampaignRepository.CampaignRepository;
import com.Xeno.XenoProject.XenoProject.CommunicationLogRepository.CommunicationLogRepository;

@RestController
@RequestMapping("/campaigns")
public class CampaignStatsController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CommunicationLogRepository logRepository;

    @GetMapping("/{id}/stats")
    public Map<String, Integer> getCampaignStats(@PathVariable Long id) {
        int total = logRepository.countByCampaign_Id(id);
        int sent = logRepository.countByCampaign_IdAndStatus(id, "SENT");
        int failed = total - sent;

        return Map.of("total", total, "sent", sent, "failed", failed);
    }
}
