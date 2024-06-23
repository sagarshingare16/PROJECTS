package com.bookitnow.service.adminService;

import com.bookitnow.dto.*;
import com.bookitnow.exception.MovieAlreadyPresent;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    String addMovie(Moviedto addMoviedto);
    String addShow(Showdto showdto);
    String addShowTickets(ShowTicketdto showTicketdto);
    String addTheater(Theaterdto theaterdto);
    String addTheaterSeats(TheaterSeatdto theaterSeatdto);

}
