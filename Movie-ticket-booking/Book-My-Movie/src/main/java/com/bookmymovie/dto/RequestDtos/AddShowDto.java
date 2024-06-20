package com.bookmymovie.dto.RequestDtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class AddShowDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate showStartTime;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate showDate;
    private Integer theaterId;
    private Integer movieId;
}
