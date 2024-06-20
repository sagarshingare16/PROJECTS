package com.bookmymovie.Transformer;

import com.bookmymovie.dto.ResponseDtos.TicketResponseDto;
import com.bookmymovie.entity.Show;
import com.bookmymovie.entity.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket) {

        return TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
               // .time(LocalTime.from(show.getTime()))
                /*.date(LocalDate.parse(show.getDate()))
                .time(LocalTime.parse(show.getTime()))*/
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();
    }
}
