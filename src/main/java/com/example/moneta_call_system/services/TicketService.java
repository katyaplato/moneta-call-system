package com.example.moneta_call_system.services;

import com.example.moneta_call_system.models.Ticket;

public interface TicketService {
    Ticket createTicket();
    void deleteLast();
    Ticket getActiveTicket();
}
