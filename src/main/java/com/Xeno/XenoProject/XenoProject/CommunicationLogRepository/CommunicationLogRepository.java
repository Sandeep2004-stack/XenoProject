package com.Xeno.XenoProject.XenoProject.CommunicationLogRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Xeno.XenoProject.XenoProject.communicationlog.CommunicationLog;
import java.util.List;

@Repository
public interface CommunicationLogRepository extends JpaRepository<CommunicationLog, Long> {
    // Custom method to find logs by campaign ID
    List<CommunicationLog> findByCampaignId(Long campaignId);
    // Count logs by campaign ID
    int countByCampaign_Id(Long campaignId);

    // Count logs by campaign ID and status
    int countByCampaign_IdAndStatus(Long campaignId, String status);
    List<CommunicationLog> findByCustomerIdAndCampaignId(Long customerId, Long campaignId);

}



