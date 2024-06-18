package com.bookmymovie.Transformer;


import com.bookmymovie.dto.RequestDtos.TheaterEntryDto;
import com.bookmymovie.entity.Theater;

public class TheaterTransformer {

    public static Theater theaterDtoToTheater(TheaterEntryDto entryDto) {
        return Theater.builder()
                .name(entryDto.getName())
                .address(entryDto.getAddress())
                .build();
    }
}
