package com.example.moneta_call_system.controllers;

import com.example.moneta_call_system.models.Ticket;
import com.example.moneta_call_system.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CallSystemControllerImpl implements CallSystemController {

    TicketService ticketService;

    @Override
    public ResponseEntity<?> createTicket() {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket());
    }

    @Override
    public ResponseEntity<?> deleteLastTicket() {
        try {
            ticketService.deleteLast();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getActualTicket() {
        try {
            Ticket activeTicket = ticketService.getActiveTicket();
            return ResponseEntity.status(HttpStatus.OK).body(activeTicket);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> finishActualTicket() {
        try {
            ticketService.deleteActive();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
