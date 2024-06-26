package com.example.moneta_call_system.services;

import com.example.moneta_call_system.repositories.TicketRepository;
import com.example.moneta_call_system.models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket createTicket() {

        List<Ticket> tickets = ticketRepository.findAll();
        int actualPosition = tickets.size();
        int queueNumber = getQueueNumber();

        Ticket newTicket = Ticket.builder()
                .queueNumber(queueNumber)
                .dateTime(LocalDateTime.now())
                .actualPosition(actualPosition)
                .build();

        tickets.add(newTicket);
        return ticketRepository.save(newTicket);
    }

    @Override
    public void deleteLast() {

    }

    @Override
    public Ticket getActiveTicket() {
        return null;
    }
}
