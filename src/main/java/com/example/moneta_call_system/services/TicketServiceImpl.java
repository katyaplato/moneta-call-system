package com.example.moneta_call_system.services;

import com.example.moneta_call_system.models.TicketLog;
import com.example.moneta_call_system.repositories.TicketLogRepository;
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
    private final TicketLogRepository ticketLogRepository;

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
        List<Ticket> tickets = ticketRepository.findAll();
        if (tickets.isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }
        Ticket theLastTicket = tickets.get(tickets.size() - 1);
        ticketRepository.delete(theLastTicket);
    }

    @Override
    public Ticket getActiveTicket() {
        Ticket actualTicket = ticketRepository.findByActualPosition(0);
        if (actualTicket == null) {
            throw new IllegalStateException("The queue is empty.");
        }
        return actualTicket;
    }

    @Override
    public void deleteActive() {
        Ticket actualTicket = ticketRepository.findByActualPosition(0);
        if (actualTicket == null) {
            throw new IllegalStateException("The queue is empty.");
        }
        ticketRepository.delete(actualTicket);
        List<Ticket> tickets = ticketRepository.findAll();
        updateActualPosition(tickets);
    }

    private void updateActualPosition(List<Ticket> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            Ticket newActualTicket = tickets.get(i);
            newActualTicket.setActualPosition(i);
            ticketRepository.save(newActualTicket);
        }
    }
    private int getQueueNumber() {
        List<TicketLog> allTickets = ticketLogRepository.findAll();
        if (allTickets.isEmpty()) {
            TicketLog firstTicket = TicketLog.builder()
                    .totalNum(0)
                    .dateTime(LocalDateTime.now())
                    .build();

            ticketLogRepository.save(firstTicket);
            return firstTicket.getTotalNum() + 1;
        }
        int theLastPosition = allTickets.get(allTickets.size() - 1).getTotalNum();

        TicketLog newTicket = TicketLog.builder()
                .dateTime(LocalDateTime.now())
                .totalNum(theLastPosition + 1)
                .build();

        ticketLogRepository.save(newTicket);
        return newTicket.getTotalNum() + 1;
    }
}
