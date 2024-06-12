package com.example.movieApp.service;

import com.example.movieApp.model.MovieTheater;
import com.example.movieApp.repository.MovieRepository;
import com.example.movieApp.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    public Integer getAvailableSetCounts(Integer theaterId){
        MovieTheater movieTheater = theaterRepository.findById(theaterId).get();
        return movieTheater.getAvailableSeats();
    }
}

