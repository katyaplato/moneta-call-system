package com.example.moneta_call_system.repositories;

import com.example.moneta_call_system.models.TicketLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketLogRepository extends JpaRepository <TicketLog, Long> {
}
