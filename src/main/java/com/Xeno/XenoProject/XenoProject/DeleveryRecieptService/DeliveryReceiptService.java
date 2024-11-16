package com.Xeno.XenoProject.XenoProject.DeleveryRecieptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.XenoProject.CommunicationLogService.CommunicationLogService;

@Service
public class DeliveryReceiptService {

    @Autowired
    private CommunicationLogService logService;

    // Simulate delivery receipt
    public void updateDeliveryReceipt(Long logId) {
        boolean isDelivered = Math.random() < 0.9; // 90% success rate
        String status = isDelivered ? "SENT" : "FAILED";
        logService.updateLogStatus(logId, status);
    }
}
