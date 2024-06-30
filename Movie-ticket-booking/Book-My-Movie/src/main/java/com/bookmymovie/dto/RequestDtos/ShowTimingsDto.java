package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShowTimingsDto {
    private LocalDate date;
    private Integer theaterId;
    private Integer movieId;
}
