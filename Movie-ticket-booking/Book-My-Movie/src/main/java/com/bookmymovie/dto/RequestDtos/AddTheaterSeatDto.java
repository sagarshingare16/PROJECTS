package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

@Data
public class AddTheaterSeatDto {
    private Integer theaterId;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}
