package com.Xeno.XenoProject.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Xeno.XenoProject.Entity.CommunicationLog;
import com.Xeno.XenoProject.Repository.CommunicationLogRepository;


@RestController
@CrossOrigin(origins = "*")
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
