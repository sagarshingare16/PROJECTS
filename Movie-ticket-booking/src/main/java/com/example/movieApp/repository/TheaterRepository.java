package com.example.movieApp.repository;

import com.example.movieApp.model.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<MovieTheater,Integer> {
}
