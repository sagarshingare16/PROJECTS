package com.example.movieApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer theaterId;
    private String theaterLocation;
    private Integer availableSeats;

    @ManyToOne
    private Movie movie;
}
