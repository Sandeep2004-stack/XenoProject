package com.Xeno.XenoProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Xeno.XenoProject.Entity.Campaign;


@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findAllByOrderByCreatedAtDesc();
}


