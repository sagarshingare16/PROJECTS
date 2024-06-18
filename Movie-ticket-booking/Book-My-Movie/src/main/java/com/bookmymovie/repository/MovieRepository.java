package com.bookmymovie.repository;


import com.bookmymovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String name);
}
