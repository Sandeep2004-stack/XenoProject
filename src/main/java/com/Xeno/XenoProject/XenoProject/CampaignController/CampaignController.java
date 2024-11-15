package com.Xeno.XenoProject.XenoProject.CampaignController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Xeno.XenoProject.XenoProject.CommunicationLogRepository.CommunicationLogRepository;
import com.Xeno.XenoProject.XenoProject.communicationlog.CommunicationLog;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    @PostMapping
    public CommunicationLog createCampaign(@RequestBody CommunicationLog log) {
        return communicationLogRepository.save(log);
    }

    @GetMapping("/logs")
    public List<CommunicationLog> getCampaignLogs() {
        return communicationLogRepository.findAll();
    }
}
