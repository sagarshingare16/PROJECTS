package com.example.movieApp.controller;

import com.example.movieApp.model.Movie;
import com.example.movieApp.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-api")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    public List<Movie> getMovies(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String location){
        return movieService.getAllMovies(date,location);
    }
}
