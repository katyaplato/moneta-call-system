package com.example.moneta_call_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int totalNum;
    private LocalDate dateTime;
}
