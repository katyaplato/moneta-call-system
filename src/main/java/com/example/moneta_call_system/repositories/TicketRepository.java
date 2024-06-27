package com.example.moneta_call_system.repositories;

import com.example.moneta_call_system.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {
    Ticket findByActualPosition(int position);
}
