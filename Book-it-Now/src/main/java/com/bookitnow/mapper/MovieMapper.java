package com.bookitnow.mapper;

import com.bookitnow.dto.Moviedto;
import com.bookitnow.model.Movie;

public class MovieMapper {
    public static Moviedto movieToMoviedto(Movie movie){
        Moviedto moviedto = new Moviedto();
        moviedto.setMovieName(movie.getMovieName());
        moviedto.setMovieGenre(movie.getMovieGenre());
        moviedto.setMovieLanguage(movie.getMovieLanguage());
        moviedto.setMovieReleaseDate(movie.getMovieReleaseDate());
        moviedto.setMovieRating(movie.getMovieRating());
        moviedto.setMovieRating(movie.getMovieRating());

        return moviedto;
    }
}
