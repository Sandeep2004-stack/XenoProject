package com.Xeno.XenoProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Xeno.XenoProject.Entity.Campaign;
import com.Xeno.XenoProject.Service.CampaignService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    // Create a new campaign
    @PostMapping
    public Campaign createCampaign(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String message = request.get("message");
        return campaignService.createCampaign(name, message, LocalDateTime.now().toString());
    }

    // Retrieve all campaigns
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    // Retrieve stats for a specific campaign
    @GetMapping("/{id}/stats")
    public Map<String, Integer> getCampaignStats(@PathVariable Long id) {
        return campaignService.getCampaignStats(id);
    }
}
