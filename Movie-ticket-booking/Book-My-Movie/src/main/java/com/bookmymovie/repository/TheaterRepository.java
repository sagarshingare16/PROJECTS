package com.bookmymovie.repository;

import com.bookmymovie.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}
