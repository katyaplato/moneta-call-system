package com.example.moneta_call_system.controllers;

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
        ticketService.deleteLast();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<?> getActualTicket() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getActiveTicket());
    }

    @Override
    public ResponseEntity<?> finishActualTicket() {
        ticketService.deleteActive();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
