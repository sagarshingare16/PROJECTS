package com.bookitnow.dto;

import lombok.Data;

@Data
public class ShowTicketdto {
    private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
