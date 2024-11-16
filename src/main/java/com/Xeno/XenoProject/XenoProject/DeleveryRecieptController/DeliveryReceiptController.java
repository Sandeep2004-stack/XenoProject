package com.Xeno.XenoProject.XenoProject.DeleveryRecieptController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Xeno.XenoProject.XenoProject.CommunicationLogRepository.CommunicationLogRepository;
import com.Xeno.XenoProject.XenoProject.communicationlog.CommunicationLog;

@RestController
@RequestMapping("/delivery-receipt")
public class DeliveryReceiptController {

    @Autowired
    private CommunicationLogRepository logRepository;

    @PostMapping
    public void updateStatus(@RequestBody Map<String, Object> payload) {
        Long logId = (Long) payload.get("logId");
        String status = (String) payload.get("status");

        CommunicationLog log = logRepository.findById(logId).orElse(null);
        if (log != null) {
            log.setStatus(status);
            logRepository.save(log);
        }
    }
}
