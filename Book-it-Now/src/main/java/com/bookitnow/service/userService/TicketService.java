package com.bookitnow.service.userService;

import com.bookitnow.builder.TicketRespBuilder;
import com.bookitnow.dto.TicketBookingdto;
import com.bookitnow.dto.TicketResponsedto;
import com.bookitnow.model.Show;
import com.bookitnow.model.ShowSeat;
import com.bookitnow.model.Ticket;
import com.bookitnow.model.User;
import com.bookitnow.repository.*;
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

    public TicketResponsedto bookTicket(TicketBookingdto ticketBookingdto){
        Optional<User> userOpt = userRepository.findById(ticketBookingdto.getUserId());
        if(userOpt.isEmpty()) {
            throw new RuntimeException();
        }
        Optional<Show> showOpt = showRepository.findById(ticketBookingdto.getShowId());
        if(showOpt.isEmpty()) {
            throw new RuntimeException();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        if(!isSeatAvailable(show.getShowSeatList(),ticketBookingdto.getRequestedSeats())){
            throw  new RuntimeException();
        }

        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),ticketBookingdto.getRequestedSeats());

        String seats = listToString(ticketBookingdto.getRequestedSeats());

        Ticket ticket = new Ticket();
        ticket.setTotalTicketPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);

        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        return TicketRespBuilder.bookedTicketToUser(show,ticket);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestedSeats) {
        for(ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNumber();
            if(requestedSeats.contains(seatNo)) {
                if(!showSeat.getIsSeatAvailable()) {
                    return false;
                }
            }
        }
        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestedSeats) {
        double totalAmount = 0;
        for(ShowSeat showSeat : showSeatList) {
            if(requestedSeats.contains(showSeat.getSeatNumber())) {
                totalAmount += showSeat.getSeatPrice();
                showSeat.setIsSeatAvailable(Boolean.FALSE);
            }
        }
        return (int) totalAmount;
    }

    private String listToString(List<String> requestSeats) {
        StringBuilder sb = new StringBuilder();
        for(String s : requestSeats) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }

}
