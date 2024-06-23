package com.bookitnow.builder;

import com.bookitnow.dto.Theaterdto;
import com.bookitnow.model.Theater;

public class TheaterBuilder {
    public static Theater theaterDtoToTheater(Theaterdto theaterdto){
        return Theater.builder()
                .theaterName(theaterdto.getTheaterName())
                .theaterLocation(theaterdto.getTheaterLocation())
                .build();
    }
}
