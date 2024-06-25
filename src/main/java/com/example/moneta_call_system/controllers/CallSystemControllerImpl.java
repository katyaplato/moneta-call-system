package com.example.moneta_call_system.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CallSystemControllerImpl implements CallSystemController {
    @Override
    public ResponseEntity<?> createTicket() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteLastTicket() {
        return null;
    }

    @Override
    public ResponseEntity<?> getActualTicket() {
        return null;
    }
}
