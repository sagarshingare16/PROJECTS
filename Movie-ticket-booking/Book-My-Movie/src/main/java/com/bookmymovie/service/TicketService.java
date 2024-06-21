package com.bookmymovie.service;

import com.bookmymovie.builder.TicketTransformer;
import com.bookmymovie.dto.RequestDtos.BookTicketDto;
import com.bookmymovie.dto.ResponseDtos.TicketResponseDto;
import com.bookmymovie.entity.Show;
import com.bookmymovie.entity.ShowSeat;
import com.bookmymovie.entity.Ticket;
import com.bookmymovie.entity.User;
import com.bookmymovie.exception.RequestedSeatAreNotAvailable;
import com.bookmymovie.exception.ShowDoesNotExists;
import com.bookmymovie.exception.UserDoesNotExists;
import com.bookmymovie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private EmailService emailService;

    public TicketResponseDto ticketBooking(BookTicketDto ticketEntryDto) throws RequestedSeatAreNotAvailable, UserDoesNotExists, ShowDoesNotExists{
        Optional<Show> showOpt = showRepository.findById(ticketEntryDto.getShowId());
        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        Optional<User> userOpt = userRepository.findById(ticketEntryDto.getUserId());
        if(userOpt.isEmpty()) {
            throw new UserDoesNotExists();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(), ticketEntryDto.getRequestSeats());
        if(!isSeatAvailable) {
            throw new RequestedSeatAreNotAvailable();
        }

        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),ticketEntryDto.getRequestSeats());

        String seats = listToString(ticketEntryDto.getRequestSeats());

        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);

        // setting foreign key variables
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        // write mail and send to user Id
        emailService.sendEmailToUser(user,show,seats);

        // build Ticket Response Dto
        return TicketTransformer.returnTicket(show, ticket);
    }


    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
        for(ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();
            if(requestSeats.contains(seatNo)) {
                if(!showSeat.getIsAvailable()) {
                    return false;
                }
            }
        }
        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats) {
        Integer totalAmount = 0;
        for(ShowSeat showSeat : showSeatList) {
            if(requestSeats.contains(showSeat.getSeatNo())) {
                totalAmount += showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }
        return totalAmount;
    }

    private String listToString(List<String> requestSeats) {
        StringBuilder sb = new StringBuilder();
        for(String s : requestSeats) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }

}
