package com.bookitnow.dto;

import lombok.Data;

import java.util.List;

@Data
public class TicketBookingdto {
    private Integer showId;
    private Integer userId;
    private List<String> requestedSeats;

}
