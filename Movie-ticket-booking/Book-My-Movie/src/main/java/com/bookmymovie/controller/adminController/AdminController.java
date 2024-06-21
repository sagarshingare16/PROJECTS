package com.bookmymovie.controller.adminController;

import com.bookmymovie.dto.RequestDtos.*;
import com.bookmymovie.service.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/add-movie")
        public ResponseEntity<String> addMovie(@RequestBody AddMovieDto addMovieDto){
        return new ResponseEntity<>(adminService.addMovie(addMovieDto), HttpStatus.CREATED);
    }

    @PostMapping("/add-show")
    public ResponseEntity<String> addShow(@RequestBody AddShowDto addShowDto) {
        return new ResponseEntity<>(adminService.addShow(addShowDto),HttpStatus.CREATED);
    }

    @PostMapping("/add-show-tickets")
    public ResponseEntity<String> addShowTickets(@RequestBody AddSeatDto addSeatDto) {
        return new ResponseEntity<>(adminService.addShowTickets(addSeatDto),HttpStatus.CREATED);
    }

    @PostMapping("/add-theater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterDto addTheaterDto) {
        return new ResponseEntity<>(adminService.addTheater(addTheaterDto),HttpStatus.CREATED);
    }

    @PostMapping("/add-theater-seats")
    public ResponseEntity<String> addTheaterSeats(@RequestBody AddTheaterSeatDto addTheaterSeatDto) {
        return new ResponseEntity<>(adminService.addTheaterSeat(addTheaterSeatDto),HttpStatus.CREATED);
    }
}
