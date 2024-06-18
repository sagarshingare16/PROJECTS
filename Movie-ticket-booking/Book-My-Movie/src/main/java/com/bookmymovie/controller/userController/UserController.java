package com.bookmymovie.controller.userController;

import com.bookmymovie.dto.RequestDtos.TicketEntryDto;
import com.bookmymovie.dto.RequestDtos.UserEntryDto;
import com.bookmymovie.dto.ResponseDtos.TicketResponseDto;
import com.bookmymovie.service.TicketService;
import com.bookmymovie.service.userService.UserService;
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
    private TicketService ticketService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntryDto userEntryDto){
        return new ResponseEntity<>(userService.addUser(userEntryDto), HttpStatus.CREATED);
    }

    @PostMapping("/book-ticket")
    public ResponseEntity<TicketResponseDto> ticketBooking(@RequestBody TicketEntryDto ticketEntryDto) {
        return new ResponseEntity<>(ticketService.ticketBooking(ticketEntryDto),HttpStatus.CREATED);
    }

    @GetMapping("/allTickets/{userId}")
    public ResponseEntity<List<TicketResponseDto>> allTickets(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.allTickets(userId),HttpStatus.OK);
    }


}
