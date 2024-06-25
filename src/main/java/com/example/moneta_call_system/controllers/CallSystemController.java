package com.example.moneta_call_system.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface CallSystemController {
    @PostMapping("/create")
    ResponseEntity<?> createTicket();
    @DeleteMapping("/delete-last")
    ResponseEntity<?> deleteLastTicket();
    @GetMapping("/get-actual")
    ResponseEntity<?> getActualTicket();
}
