package com.bookitnow.service.userService;

import com.bookitnow.builder.TicketRespBuilder;
import com.bookitnow.builder.UserBuilder;

import com.bookitnow.dto.Userdto;
import com.bookitnow.dto.TicketResponsedto;
import com.bookitnow.model.Ticket;
import com.bookitnow.model.User;
import com.bookitnow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public String registerUser(Userdto addUserdto){
        if(userRepository.findByUserEmailId(addUserdto.getUserEmailId()) != null){
            throw new RuntimeException();
        }
        User user = UserBuilder.userDtoToUser(addUserdto);
        userRepository.save(user);
        return "User registered successfully..";
    }

    public List<TicketResponsedto> allBookedTickets(Integer userId){
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isEmpty()) {
            throw new RuntimeException();
        }
        User user = userOpt.get();
        List<Ticket> ticketList = user.getTicketList();
        List<TicketResponsedto> ticketResponsedtos = new ArrayList<>();

        for(Ticket ticket : ticketList){
            ticketResponsedtos.add(TicketRespBuilder.bookedTicketToUser(ticket.getShow(),ticket));
        }
        return ticketResponsedtos;
    }
}
