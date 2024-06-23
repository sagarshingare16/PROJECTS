package com.bookitnow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_details")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String movieName;
    private String MovieLanguage;
    private List<String> movieGenre;
    private double movieDuration;
    private double movieRating;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate movieReleaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();
}
