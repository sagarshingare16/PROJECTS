package com.bookmymovie.builder;


import com.bookmymovie.dto.RequestDtos.AddMovieDto;
import com.bookmymovie.entity.Movie;

import java.time.LocalDate;

public class MovieTransformer {

    public static Movie movieDtoToMovie(AddMovieDto movieEntryDto) {
        return Movie.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .releaseDate(LocalDate.parse(String.valueOf(movieEntryDto.getReleaseDate())))
                .rating(movieEntryDto.getRating())
                .build();
    }
}
