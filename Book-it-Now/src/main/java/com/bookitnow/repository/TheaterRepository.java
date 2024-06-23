package com.bookitnow.repository;

import com.bookitnow.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    Theater findByTheaterName(String theaterName);
}
