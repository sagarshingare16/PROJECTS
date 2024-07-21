package com.bookitnow.controller.userController;

import com.bookitnow.dto.Moviedto;
import com.bookitnow.dto.TicketBookingdto;
import com.bookitnow.dto.Userdto;
import com.bookitnow.dto.TicketResponsedto;
import com.bookitnow.service.ticketService.TicketService;
import com.bookitnow.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Userdto addUserdto){
        return new ResponseEntity<>(userService.registerUser(addUserdto), HttpStatus.CREATED);
    }

    @PostMapping("/book-ticket")
    public ResponseEntity<TicketResponsedto> bookTicket(@RequestBody TicketBookingdto ticketBookingdto){
        return new ResponseEntity<>(ticketService.bookTicket(ticketBookingdto),HttpStatus.CREATED);
    }

    @GetMapping("/all-tickets/{userId}")
    public ResponseEntity<List<TicketResponsedto>> allBookedTickets(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.allBookedTickets(userId),HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Moviedto>> getAllMovies(){
        return new ResponseEntity<>(userService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/movies/{movieName}")
    public ResponseEntity<Moviedto> getMovieByName(@PathVariable String movieName){
        return new ResponseEntity<>(userService.getMovieByName(movieName),HttpStatus.OK);
    }
}
