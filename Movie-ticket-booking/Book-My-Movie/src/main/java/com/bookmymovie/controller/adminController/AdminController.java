package com.bookmymovie.controller.adminController;

import com.bookmymovie.dto.RequestDtos.*;
import com.bookmymovie.service.adminService.AdminService;
import com.bookmymovie.service.userService.UserService;
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
    public ResponseEntity<String> addNewMovie(@RequestBody MovieEntryDto movieEntryDto){
        return new ResponseEntity<>(adminService.addMovie(movieEntryDto), HttpStatus.CREATED);
    }

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto) {
        return new ResponseEntity<>(adminService.addShow(showEntryDto),HttpStatus.CREATED);
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatEntryDto showSeatEntryDto) {
        return new ResponseEntity<>(adminService.associateShowSeats(showSeatEntryDto),HttpStatus.CREATED);
    }

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        return new ResponseEntity<>(adminService.addTheater(theaterEntryDto),HttpStatus.CREATED);
    }

    @PostMapping("/addTheaterSeat")
    public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatEntryDto entryDto) {
        return new ResponseEntity<>(adminService.addTheaterSeat(entryDto),HttpStatus.CREATED);
    }
}
