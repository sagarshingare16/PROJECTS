package com.bookmymovie.builder;

import com.bookmymovie.dto.RequestDtos.AddShowDto;
import com.bookmymovie.entity.Show;

public class ShowTransformer {

    public static Show showDtoToShow(AddShowDto showEntryDto) {

        return Show.builder()
                .time(showEntryDto.getShowStartTime())
                .date(showEntryDto.getShowDate())
                .build();
    }
}
