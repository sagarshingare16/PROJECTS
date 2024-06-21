package com.bookmymovie.builder;

import com.bookmymovie.dto.ResponseDtos.TicketResponseDto;
import com.bookmymovie.entity.Show;
import com.bookmymovie.entity.Ticket;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket) {

        return TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();
    }
}
