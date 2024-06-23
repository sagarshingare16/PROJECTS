package com.bookitnow.service.userService;

import com.bookitnow.dto.Userdto;
import com.bookitnow.dto.TicketResponsedto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String registerUser(Userdto addUserdto);
    List<TicketResponsedto> allBookedTickets(Integer userId);
}
