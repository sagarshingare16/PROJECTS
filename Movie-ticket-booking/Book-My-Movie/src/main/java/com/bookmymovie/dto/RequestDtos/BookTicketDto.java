package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketDto {
    private Integer showId;
    private Integer userId;
    private List<String> requestSeats;
}
