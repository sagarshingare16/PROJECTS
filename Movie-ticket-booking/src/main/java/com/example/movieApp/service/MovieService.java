package com.example.movieApp.service;

import com.example.movieApp.model.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface MovieService {
    List<Movie> filterMovies(LocalDate date,String location);
    List<Movie> getAllMovies(LocalDate date,String location);
}
