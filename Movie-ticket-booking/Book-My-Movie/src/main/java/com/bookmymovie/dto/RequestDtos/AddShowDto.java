package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowDto {
    private LocalTime showStartTime;
    private LocalDate showDate;
    private Integer theaterId;
    private Integer movieId;
}
