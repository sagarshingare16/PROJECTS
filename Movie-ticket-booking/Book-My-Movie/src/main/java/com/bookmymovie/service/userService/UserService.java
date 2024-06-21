package com.bookmymovie.service.userService;

import com.bookmymovie.builder.TicketTransformer;
import com.bookmymovie.builder.UserTransformer;
import com.bookmymovie.dto.RequestDtos.AddUserDto;
import com.bookmymovie.dto.ResponseDtos.TicketResponseDto;
import com.bookmymovie.entity.Ticket;
import com.bookmymovie.entity.User;
import com.bookmymovie.exception.UserAlreadyExistsWithEmail;
import com.bookmymovie.exception.UserDoesNotExists;
import com.bookmymovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserDto addUserDto) throws UserAlreadyExistsWithEmail {
        if(userRepository.findByEmailId(addUserDto.getEmailId()) != null) {
            throw new UserAlreadyExistsWithEmail();
        }
        User user = UserTransformer.userDtoToUser(addUserDto);

        userRepository.save(user);
        return "User Saved Successfully";
    }

    public List<TicketResponseDto> allTickets(Integer userId) throws UserDoesNotExists {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isEmpty()) {
            throw new UserDoesNotExists();
        }
        User user = userOpt.get();
        List<Ticket> ticketList = user.getTicketList();
        List<TicketResponseDto> ticketResponseDtos = new ArrayList<>();
        for(Ticket ticket : ticketList) {
            TicketResponseDto ticketResponseDto = TicketTransformer.returnTicket(ticket.getShow(), ticket);
            ticketResponseDtos.add(ticketResponseDto);
        }
        return ticketResponseDtos;
    }

}
