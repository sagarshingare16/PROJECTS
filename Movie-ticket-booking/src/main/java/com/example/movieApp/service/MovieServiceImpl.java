package com.example.movieApp.service;

import com.example.movieApp.model.Movie;
import com.example.movieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> filterMovies(LocalDate date, String location) {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for(Movie movie : movieList){
            boolean match = true;
            if (date != null && !movie.getMovieReleaseDate().isEqual(date)) {
                match = false;
            }
            if (location != null && !movie.getMovieTheater().getTheaterLocation().toUpperCase().contains(location.toLowerCase())) {
                match = false;
            }
            if (match) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    @Override
    public List<Movie> getAllMovies(LocalDate date, String location) {
        if(date == null && location == null){
            return movieRepository.findAll();
        }else {
            return filterMovies(date,location);
        }
    }
}
