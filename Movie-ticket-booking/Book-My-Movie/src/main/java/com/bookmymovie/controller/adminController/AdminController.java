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


    @PostMapping("/addMovie")
        public ResponseEntity<String> addNewMovie(@RequestBody AddMovieDto addMovieDto){
        return new ResponseEntity<>(adminService.addMovie(addMovieDto), HttpStatus.CREATED);
    }

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody AddShowDto addShowDto) {
        return new ResponseEntity<>(adminService.addShow(addShowDto),HttpStatus.CREATED);
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody AddSeatDto addSeatDto) {
        return new ResponseEntity<>(adminService.associateShowSeats(addSeatDto),HttpStatus.CREATED);
    }

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterDto addTheaterDto) {
        return new ResponseEntity<>(adminService.addTheater(addTheaterDto),HttpStatus.CREATED);
    }

    @PostMapping("/addTheaterSeat")
    public ResponseEntity<String> addTheaterSeat(@RequestBody AddTheaterSeatDto addTheaterSeatDto) {
        return new ResponseEntity<>(adminService.addTheaterSeat(addTheaterSeatDto),HttpStatus.CREATED);
    }
}
