package com.bookmymovie.dto.RequestDtos;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class AddShowDto {

    private Time showStartTime;
    private LocalDate showDate;
    private Integer theaterId;
    private Integer movieId;
}
