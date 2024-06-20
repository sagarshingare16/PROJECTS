package com.bookmymovie.Transformer;


import com.bookmymovie.dto.RequestDtos.AddTheaterDto;
import com.bookmymovie.entity.Theater;

public class TheaterTransformer {

    public static Theater theaterDtoToTheater(AddTheaterDto entryDto) {
        return Theater.builder()
                .name(entryDto.getName())
                .address(entryDto.getAddress())
                .build();
    }
}
