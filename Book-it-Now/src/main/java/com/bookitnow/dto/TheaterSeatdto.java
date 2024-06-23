package com.bookitnow.dto;

import lombok.Data;

@Data
public class TheaterSeatdto {
    private int theaterId;
    private int totalNumberOfSeats;
    private int totalNumberOfPremiumSeats;
    private int totalNumberOfClassicSeats;

}
