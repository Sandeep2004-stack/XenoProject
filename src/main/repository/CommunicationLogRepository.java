package com.Xeno.XenoProject.XenoProject.CommunicationLogRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Xeno.XenoProject.XenoProject.communicationlog.CommunicationLog;

public interface CommunicationLogRepository extends JpaRepository< CommunicationLog, Long> {

	
}
