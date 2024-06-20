package com.bookmymovie.dto.RequestDtos;


import com.bookmymovie.enums.Genre;
import com.bookmymovie.enums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieDto {
    private String movieName;
    private Integer duration;
    private Double rating;
    private LocalDate releaseDate;
    private Genre genre;
    private Language language;
}
