package com.bookitnow.builder;

import com.bookitnow.dto.Showdto;
import com.bookitnow.model.Show;

public class ShowBuilder {
    public static Show showDtoToShow(Showdto showdto){
        return Show.builder()
                .showDate(showdto.getShowDate())
                .showTime(showdto.getShowTime())
                .build();
    }
}
