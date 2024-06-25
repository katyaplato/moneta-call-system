package com.example.moneta_call_system.services;

import com.example.moneta_call_system.TicketRepository;
import com.example.moneta_call_system.models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket createTicket() {
        return null;
    }

    @Override
    public void deleteLast() {

    }

    @Override
    public Ticket getActiveTicket() {
        return null;
    }
}
