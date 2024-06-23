package com.bookitnow.builder;

import com.bookitnow.dto.TicketResponsedto;
import com.bookitnow.model.Show;
import com.bookitnow.model.Ticket;

public class TicketRespBuilder {
    public static TicketResponsedto bookedTicketToUser(Show show, Ticket ticket){
        return TicketResponsedto.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getTheaterName())
                .theaterLocation(show.getTheater().getTheaterLocation())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .bookedSeats(ticket.getBookedSeats())
                .totalTicketCost(ticket.getTotalTicketPrice())
                .build();
    }
}
