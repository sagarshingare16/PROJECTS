package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

@Data
public class AddSeatDto {
    private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
