package com.bookitnow.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Moviedto {
    private String movieName;
    private String MovieLanguage;
    private List<String> movieGenre;
    private double movieDuration;
    private double movieRating;
    private LocalDate movieReleaseDate;
}
