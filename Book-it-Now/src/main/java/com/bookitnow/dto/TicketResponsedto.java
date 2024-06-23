package com.bookitnow.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class TicketResponsedto {
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theaterName;
    private String theaterLocation;
    private String bookedSeats;
    private double totalTicketCost;

}
