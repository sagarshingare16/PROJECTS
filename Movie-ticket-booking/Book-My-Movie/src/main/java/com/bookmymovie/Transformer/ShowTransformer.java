package com.bookmymovie.Transformer;

import com.bookmymovie.dto.RequestDtos.AddShowDto;
import com.bookmymovie.entity.Show;

import java.time.LocalDate;

public class ShowTransformer {

    public static Show showDtoToShow(AddShowDto showEntryDto) {

        return Show.builder()
                .time(String.valueOf(showEntryDto.getShowStartTime()))
                .date(LocalDate.parse(String.valueOf(showEntryDto.getShowDate())))
                .build();
    }
}
