package com.Xeno.XenoProject.XenoProject.CampaignRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Xeno.XenoProject.XenoProject.Campaign.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findAllByOrderByCreatedAtDesc();
}

