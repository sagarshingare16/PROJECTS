package com.bookitnow.builder;

import com.bookitnow.dto.Moviedto;
import com.bookitnow.model.Movie;

public class MovieBuilder {
    public static Movie movieDtoToMovie(Moviedto addMoviedto){
        return Movie.builder()
                .movieName(addMoviedto.getMovieName())
                .MovieLanguage(addMoviedto.getMovieLanguage())
                .movieReleaseDate(addMoviedto.getMovieReleaseDate())
                .movieGenre(addMoviedto.getMovieGenre())
                .movieRating(addMoviedto.getMovieRating())
                .movieDuration(addMoviedto.getMovieDuration())
                .build();
    }
}
