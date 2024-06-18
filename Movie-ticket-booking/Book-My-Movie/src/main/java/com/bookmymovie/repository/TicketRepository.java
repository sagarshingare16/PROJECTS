package com.bookmymovie.repository;

import com.bookmymovie.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
