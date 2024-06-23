package com.bookitnow.controller.adminController;

import com.bookitnow.dto.*;
import com.bookitnow.service.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Moviedto moviedto){
        return new ResponseEntity<>(adminService.addMovie(moviedto), HttpStatus.CREATED);
    }

    @PostMapping("/add-show")
    public ResponseEntity<String> addShow(@RequestBody Showdto showdto) {
        return new ResponseEntity<>(adminService.addShow(showdto),HttpStatus.CREATED);
    }

    @PostMapping("/add-show-tickets")
    public ResponseEntity<String> addShowTickets(@RequestBody ShowTicketdto showTicketdto) {
        return new ResponseEntity<>(adminService.addShowTickets(showTicketdto),HttpStatus.CREATED);
    }

    @PostMapping("/add-theater")
    public ResponseEntity<String> addTheater(@RequestBody Theaterdto theaterdto) {
        return new ResponseEntity<>(adminService.addTheater(theaterdto),HttpStatus.CREATED);
    }

    @PostMapping("/add-theater-seats")
    public ResponseEntity<String> addTheaterSeats(@RequestBody TheaterSeatdto theaterSeatdto) {
        return new ResponseEntity<>(adminService.addTheaterSeats(theaterSeatdto),HttpStatus.CREATED);
    }

}
