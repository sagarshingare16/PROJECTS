package com.example.movieApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer movieId;
    private String movieTitle;
    private String movieDesc;
    private String movieTrailerLink;
    private String moviePoster;
    private List<String> genres;
    private List<String> movieCast;
    private String movieDirector;
    private LocalDate movieReleaseDate;

    @OneToMany(mappedBy = "movie")
    private List<MovieTheater> movieTheaterList = new ArrayList<>();
}
